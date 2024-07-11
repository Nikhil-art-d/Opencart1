package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//Constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator 
	
	@FindBy(xpath="//input[@id='input-email']")WebElement username;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	

	
	//ACtions Method
	
	
	public void setUsername(String email)
	{
		username.sendKeys(email);
	}
	
	public void setpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickonLoginbtn()
	{
		loginbtn.click();
	}
	
}
