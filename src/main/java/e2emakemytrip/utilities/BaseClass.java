package e2emakemytrip.utilities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import e2e.pageobjects.Homepage;

public class BaseClass extends CommonActions {

	protected static WebDriver driver;
	protected static Logger logger= LogManager.getLogger();
	private String url="https://www.goibibo.com/flights/";
	
	@BeforeTest
	public void loadBrowser()
	{
		System.setProperty("webdriver.chrome.diver", 
				System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
		try
		{
			driver=new ChromeDriver();
			logger.info("Opening the Broswer");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
			logger.info("Launching url "+url);
		}catch(Exception e)
		{
			logger.error(e);
		}
	}
	
	
//	public void searchFlight() throws InterruptedException {
//		
//		Homepage homepage=new Homepage(driver);
//		
//		homepage.clickToCloseLoginFrame();
//		homepage.selectFromLocation();
//		homepage.selectToLocation();
//		homepage.clickOnSearchButton();
//	
//	}

	//@AfterTest
	public void closeConnection() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
		logger.info("Closing the browser");
	}
}
