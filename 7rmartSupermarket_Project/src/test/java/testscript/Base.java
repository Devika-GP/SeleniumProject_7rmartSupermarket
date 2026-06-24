package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	public Properties properties;
	public FileInputStream fileinputstream;
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun=true)
	public void browserInitialization(String browser) throws Exception {
		try {
			properties = new Properties();
			fileinputstream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();	
		}
		
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else
		{
			throw new Exception("Invalid browser name");
		}
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}

	/*
	 * @AfterMethod public void browserQuitandClose() { driver.quit(); }
	 */
	
	@AfterMethod(alwaysRun=true)
	public void browserQuitandClose(ITestResult iTestResult) throws IOException {
	    if (iTestResult.getStatus() == ITestResult.FAILURE) {
	        ScreenshotUtility screenShot = new ScreenshotUtility(); // creating obj
	        screenShot.getScreenShot(driver, iTestResult.getName());
	    }
	    driver.quit();
	}

}
