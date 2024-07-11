package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.AccountRegistrationPage;
import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	

	
	@Test(groups= {"Regression","master"})
	public void validate_acc_registration()throws InterruptedException {

		try {
			
			logger.info("***  Starting TC_001_AccountRegistrationTest ***");

			HomePage hm = new HomePage(driver);
			hm.myAccount();
			logger.info("Click on My Account");

			hm.registar();
			hm.myAccount();
			logger.info("Click on Register tab");
			
			AccountRegistrationPage repage = new AccountRegistrationPage(driver);
			
			logger.info("Provinding Data for Registring the Customer");
			
			repage.firstName(randomeString().toUpperCase());
			repage.setlastname(randomeString().toUpperCase());
			repage.setEmail(randomeString() + "@gmail.com");

			repage.setTelephone(randomeNumber());

			String pwdd = randomAlphaNumeric();
			repage.setPassword(pwdd);
			repage.Confirmpassword(pwdd);

			repage.agreed();
			repage.continuesous();
			
			logger.info("Click on Continues ");

			String confirm = repage.getConfirmationMsg();

			// Validation
			
			
			logger.info("Validating Expected message ");
			Assert.assertEquals(confirm, "Your Account Has Been Created!");
			
		
		   

		}

		catch (Exception e) {
				
			Assert.fail();
		}

		logger.info("***** Finished TC_001_AccountRegistrationTest  *********");
	}

}
