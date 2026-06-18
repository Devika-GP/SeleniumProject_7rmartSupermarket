package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LogoutPage {

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement dropdownbutton;
	@FindBy(css = "i.ace-icon.fa.fa-power-off")
	WebElement logoutbutton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinbutton;

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickDropDownMenu(WebDriver driver) {
		pageutility.clickUsingJavaScript(driver, dropdownbutton);
	}

	public void clickLogoutButton() {
		pageutility.clickUsingJavaScript(driver, logoutbutton);
	}

	public boolean isSigninButtonDisplayed() {
		return signinbutton.isDisplayed();
	}

}
