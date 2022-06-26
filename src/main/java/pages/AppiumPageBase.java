package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AppiumPageBase {

	public static AppiumDriver AppiumDriver;



	// create constructor
	public AppiumPageBase(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button)
	{
		button.click();
	}

	protected static void setTextElementText(WebElement textElement , String value)
	{
		textElement.sendKeys(value);
	}
	

}
