package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDriverntest extends BaseClass{

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDtest(String email, String password, String exp)
	{
		try {
		HomePage hp=new HomePage(driver);
		hp.myAccount();
		hp.loginClickonHomePage();
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(email);
		lp.setpassword(password);
		lp.clickonLoginbtn();
		
		MyAccountPage mpage=new MyAccountPage(driver);
		boolean targetpage=mpage.isAccountPageDisplay();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				mpage.logoutmethod();
				Assert.assertTrue(true);
			}
			
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				mpage.logoutmethod();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
