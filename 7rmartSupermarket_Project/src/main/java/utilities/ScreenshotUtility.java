package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot takescreenshot = (TakesScreenshot) driver; // TakesScreenshot captures the current situation on
																	// browser
		File screenShot = takescreenshot.getScreenshotAs(OutputType.FILE); // this takes the screenshot, stores as a
																			// temp file
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
		File file = new File(System.getProperty("user.dir") + "/outputScreenShot"); // OutputScreenShot is generated in
																					// this location only. Folder path
																					// to store output screenshot given
																					// here

		if (!file.exists()) {
			file.mkdirs(); // create a folder if it doesn't exist
		}

		String destination = System.getProperty("user.dir") + "/outputScreenShot/" + failedTestCase + timeStamp
				+ ".png"; // decide final screenshot path. file name + time stamp + image extension
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); // FileHandler-class: to copy screenshot from one location to another
	}
}
