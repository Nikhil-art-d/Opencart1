package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static public WebDriver driver;
	public  Logger logger;
	public Properties p;
	
	@BeforeClass(groups={"sanity","Regression","master"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws InterruptedException, IOException
	
	{
		
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		
		 //for selenium grid for remote selection
		 if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		 {
			 DesiredCapabilities capability=new DesiredCapabilities();
			 
			 if(os.equalsIgnoreCase("window"))
			 {
				 capability.setPlatform(Platform.WIN11);
			 }
			 else if(os.equalsIgnoreCase("Linux"))
			 {
				 capability .setPlatform(Platform.LINUX);
			 }
			 
			 else
			 {
				 System.out.println("No matching os");
					return;
			 }
			 
			 
			 //browser
			 switch(br.toLowerCase())
				{
				case "chrome": capability.setBrowserName("chrome"); break;
				case "edge": capability.setBrowserName("MicrosoftEdge"); break;
				default: System.out.println("No matching browser"); return;
				}
			 
			
			 driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
			 
			 
		 }
		 

		 //for selenium grid for local selection
		 	 
		if(p.getProperty("execution_env").equals("local")) {
		 
		    switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println("No matching browser..");
						return;
			
			}
		 
		}
		
		logger=LogManager.getLogger(this.getClass());  //for logging
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost/opencart/upload/index.php");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//driver.manage().deleteAllCookies();
		
		
		
	}
	
	@AfterClass(groups={"sanity","Regression","master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".PNG";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
	
	
	
	
	
	
}
