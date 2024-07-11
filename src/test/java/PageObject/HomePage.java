package PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	
	public WebDriver driver;
	
	//Constructor
	public  HomePage (WebDriver driver) {
		
		super(driver);
		
	}
	
	//Elements
	

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(linkText = "Register")
	WebElement lnkRegister;
		
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement Loginlink;
	
	
	//Action Method
	
	public void myAccount()
	{
		lnkMyaccount.click();
		
		//sol2 
		//lnkMyaccount.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(lnkMyaccount).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", lnkMyaccount);
		
		//Sol 5
		//lnkMyaccount.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(lnkMyaccount)).click();
		
		
	}

	public void registar()
	{
		lnkRegister.click();
		//sol2 
		//register.submit();
			
			//sol3
			//Actions act=new Actions(driver);
			//act.moveToElement(lnkRegister).click().perform();
						
			//sol4
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", lnkRegister);
			
			//Sol 5
			//register.sendKeys(Keys.RETURN);
			
			//Sol6  
			//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//mywait.until(ExpectedConditions.elementToBeClickable(lnkRegister)).click();
			
	}

	public void loginClickonHomePage()
	{
		Loginlink.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
