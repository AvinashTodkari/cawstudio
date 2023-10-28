package Module_TestData_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class demo 
{
public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException 
{
System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome\\118\\chromedriver-win64\\chromedriver.exe");
	
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
	driver.findElement(By.xpath("//div[@class='centered']//summary[text()='Table Data']")).click();
	
	WebElement inputtextbox = driver.findElement(By.id("jsondata"));
	inputtextbox.clear();
	inputtextbox.sendKeys("[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n" + 
			"\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n" + 
			"\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]");
	
	Thread.sleep(5000);
	
	driver.findElement(By.id("refreshtable")).click();

    List<WebElement> cells = driver.findElements(By.xpath("(//table[@id='dynamictable']/tr)/td"));
    List<String> firstLoopData = new ArrayList<String>();
    for (WebElement cell : cells) 
    {
        String tablecells = cell.getText();
        System.out.println(tablecells);
        firstLoopData.add(tablecells);
    }
	
    FileInputStream file=new FileInputStream("C:\\Users\\SSK\\Desktop\\CawStudio.xlsx");
	Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
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
}
