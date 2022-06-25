package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="email")
	WebElement emailTxtBox ; 

	@FindBy(id="password")
	WebElement passwordTxtBox ; 

	@FindBy(linkText=" Sign In ")
	WebElement loginBtn ; 
	
	public void addCridintioal(String email , String password)
	{
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);

	}
	public void clickLogin(String email , String password)
	{
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}

}
