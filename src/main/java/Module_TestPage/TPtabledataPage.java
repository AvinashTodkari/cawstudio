package Module_TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TPtabledataPage 
{
@FindBy(xpath="//div/details/summary[text()='Table Data']") private WebElement tabledata;

public TPtabledataPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void click_tabledata_button()
{
	tabledata.click();
}
}
