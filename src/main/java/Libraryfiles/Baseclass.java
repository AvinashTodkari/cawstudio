package Libraryfiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Baseclass 
{
	public WebDriver driver;
public void Initializebrowser()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\SSK\\eclipse-workspace\\Testing\\Browser_files\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
}
}

//{
//	{
//		
//		public WebDriver driver;
//		public void initializebrowser()
//		{
//			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome\\118\\chrome-win64\\chrome.exe");
//			driver=new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
//			driver.get("https://www.flipkart.com/");
//		}
//		}
//
//}
