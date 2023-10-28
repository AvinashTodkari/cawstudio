package Module_TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TPinputtextboxPage
{
@FindBy(id="jsondata") private WebElement inputtextbox;
@FindBy(id="refreshtable") private WebElement refreshbtn;

public TPinputtextboxPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void set_inputtextbox() throws InterruptedException
{
	inputtextbox.clear();
	inputtextbox.sendKeys("[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n" + 
			"\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n" + 
			"\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]");
	//Thread.sleep(2000);
}

public void click_refreshbutton()
{
	refreshbtn.click();
}
}
