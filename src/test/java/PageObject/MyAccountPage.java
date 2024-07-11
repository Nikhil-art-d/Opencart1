package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

	//Constructor
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement accpage; // MyAccount Page heading
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logoutbtn;
	
	
	//Action Method
	
	public boolean isAccountPageDisplay()
	{
		try 
		{
			boolean accshow=accpage.isDisplayed();
			return accshow;
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
	public void logoutmethod()
	{
		logoutbtn.click();
	}
	
	
	
}
