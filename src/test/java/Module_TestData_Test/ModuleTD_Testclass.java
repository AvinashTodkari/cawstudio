package Module_TestData_Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Libraryfiles.Baseclass;
import Libraryfiles.utilityclass;
import Module_TestPage.TPinputtextboxPage;
import Module_TestPage.TPtabledataPage;

public class ModuleTD_Testclass extends Baseclass
{
TPinputtextboxPage input;
TPtabledataPage tdata;

@BeforeClass
public void openbrowser() throws Exception
{
	Initializebrowser();
	Libraryfiles.MyscreenRecorder.startRecord("cawstudio");
	input=new TPinputtextboxPage(driver);
	tdata=new TPtabledataPage(driver);
	
}
@BeforeMethod
public void setinputintable() throws InterruptedException
{
	tdata.click_tabledata_button();
	input.set_inputtextbox();
	Thread.sleep(5000);
	input.click_refreshbutton();
	Thread.sleep(2000);
}

@Test
public void verifytabledata() throws EncryptedDocumentException, IOException
{
	List<WebElement> cells = driver.findElements(By.xpath("(//table[@id='dynamictable']/tr)/td"));
    List<String> firstLoopData = new ArrayList<String>();
    for (WebElement cell : cells) 
    {
        String tablecells = cell.getText();
        System.out.println(tablecells);
        firstLoopData.add(tablecells);
    }
	
    Sheet sh = utilityclass.getsheet();
	List<String> secondLoopData = new ArrayList<String>();
	int lastrowindex = sh.getLastRowNum();
	for(int i=0;i<=lastrowindex;i++)		//outer for loop for row
	{
		int lastcellnum = sh.getRow(i).getLastCellNum()-1;
		for(int j=0;j<=lastcellnum;j++)		//inner for loop for column
		{
			String value = sh.getRow(i).getCell(j).getStringCellValue();
			secondLoopData.add(value);
		}
		
	}

	 for (int i = 0; i < firstLoopData.size(); i++)
	 {
         String firstValue = firstLoopData.get(i);
         String secondValue = secondLoopData.get(i);
         Assert.assertEquals(firstValue, secondValue,"failed");

         if (firstValue.equals(secondValue)) {
             System.out.println("Values match for index " + i + ": " + firstValue);
         } else {
             System.out.println("Values do not match for index " + i + ": " + firstValue + " vs " + secondValue);
         }
     }
	 


	}
@AfterClass
public void closebrowser() throws Exception
{
	Thread.sleep(3000);
	driver.quit();
	Libraryfiles.MyscreenRecorder.stopRecord();
}
}


