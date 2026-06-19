package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void dropDownVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void dropDownIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void dropDownValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions rightclick = new Actions(driver);
		rightclick.contextClick(element);
	}
	
	public void dragAndDrop(WebDriver driver, WebElement sourceelement, WebElement targetelement) {
		Actions draganddrop = new Actions(driver);
		draganddrop.dragAndDrop(sourceelement, targetelement).perform();
	}
	
	//do other action methods, alert etc
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	//hidden elements can be clicked using Actions class
	public void clickmethod(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.click().perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	//simple alert, confirmation alert, prompt alert
	public void simpleAlertHandling(WebDriver driver, String text) {
		//switching to alert box using Alert interface
		Alert simplealert = driver.switchTo().alert();
		String actualtext = simplealert.getText();
		if(actualtext.equals(text)) {
			System.out.println("Alert message is: "+actualtext);
			simplealert.accept();
		}
		else {
			System.out.println("Text mismatch. Validation failed!");
		}
	}
	
	public void confirmAlertHandling(WebDriver driver) {
		
		//switching to alert box using Alert interface
		Alert confirmalert = driver.switchTo().alert();
		confirmalert.accept();
		//confirmalert.dismiss();
	}
	
	public void promptAlertHandling(WebDriver driver, String text) {
		
		Alert promptalert = driver.switchTo().alert();
		promptalert.sendKeys(text);
		promptalert.accept();
		//promptalert.dismiss();
	}
	
	public void scrollDownUsingJavaScript(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)",""); // scrolling down: 0 = x-axis, 150 pixels = y-axis
	}
	
	public void scrollUpUsingJavaScript(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-100)", ""); //scrolling up
	}
	
	public void scrollEntirePageUsingJavaScript(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", ""); //scrolls entire height of the page
	}
	
	public void clickUsingJavaScript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void sendKeysUsingJavaScript(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "';", element);
	}
}
