package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboardbutton;
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	WebElement alertmessage;

	public WebDriver driver;
	WaitUtility wait = new WaitUtility();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage verifyLogin(String username, String password) {
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		loginbutton.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplayed() {
		return dashboardbutton.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alertmessage.isDisplayed();
	}

}
