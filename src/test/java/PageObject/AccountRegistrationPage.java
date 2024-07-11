package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	
	//Construction
	public AccountRegistrationPage (WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	
	    @FindBy(xpath="//input[@id='input-firstname']")  WebElement firstName;
		@FindBy(xpath="//input[@id='input-lastname']")  WebElement lastName;
		@FindBy(xpath="//input[@id='input-email']")  WebElement eMail;
		@FindBy(xpath="//input[@id='input-telephone']")  WebElement telephone;
		@FindBy(xpath="//input[@id='input-password']")  WebElement password;
		@FindBy(xpath="//input[@id='input-confirm']")  WebElement passwordConfirm;
		@FindBy(xpath="//input[@name='agree']")   WebElement agree;
		@FindBy(xpath="//input[@value='Continue']") WebElement Continue;
		@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	
	//ACtion Method
	
	
	public void firstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	
	public void setlastname(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	
	public void setEmail(String email)
	{
		eMail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		telephone.click();
		
		telephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
		
	}
	
	public void Confirmpassword(String pwd)
	{
		
		passwordConfirm.sendKeys(pwd);
		//register.click();
		//sol1 
		//register.click();
		
		//sol2 
		//register.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//register.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(register)).click();
		
	}
	
	public void agreed()
	{
		agree.click();
	}
	
	public void continuesous()
	{
	
		Continue.click();
		
		//Continue.click();
				//sol1 
				//register.click();
				
				//sol2 
				//Continue.submit();
				
				//sol3
				//Actions act=new Actions(driver);
				//act.moveToElement(Continue).click().perform();
							
				//sol4
				//JavascriptExecutor js=(JavascriptExecutor)driver;
				//js.executeScript("arguments[0].click();", Continue);
				
				//Sol 5
				//register.sendKeys(Keys.RETURN);
				
				//Sol6  
				//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
				//mywait.until(ExpectedConditions.elementToBeClickable(Continue)).click();
				
		
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
	
	
	
	
	
	
	
	
	
	
}
