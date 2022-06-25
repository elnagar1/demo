package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AppiumPageBase {

	protected AppiumDriver appiumDrvier ;



	// create constructor
	public AppiumPageBase(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	

}
