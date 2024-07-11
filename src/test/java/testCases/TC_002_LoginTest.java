package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"sanity","master"})
	public void Verify_loginTest  () throws InterruptedException
	{
		logger.info("******** Login test Start *******");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.myAccount();
		hp.loginClickonHomePage();
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickonLoginbtn();
		
		MyAccountPage mpage=new MyAccountPage(driver);
		boolean targetpage=mpage.isAccountPageDisplay();
		
		Assert.assertEquals(targetpage, true,"Login Failed:");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginTest  ****");
		
	}

	
	
	
	
	
	
	
}
