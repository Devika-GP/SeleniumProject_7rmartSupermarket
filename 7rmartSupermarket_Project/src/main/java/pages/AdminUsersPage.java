package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	/*
	 * @FindBy(xpath =
	 * "//a[contains(@href,'list-admin') and @class='small-box-footer']") WebElement
	 * moreinfo;
	 */
	@FindBy(css = "a.btn.btn-rounded.btn-danger")
	WebElement newbutton;
	@FindBy(css = "input#username")
	WebElement username;
	@FindBy(css = "input#password")
	WebElement password;
	@FindBy(css = "select#user_type")
	WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savebutton;
	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement alert;

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void navigateToAdminUsers() { moreinfo.click(); }
	 */

	public AdminUsersPage clickNewButton() {
		newbutton.click();
		return this;
	}
	
	public AdminUsersPage enterUsername(String username) {
		this.password.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage enterPassword(String password) {
		this.password.sendKeys(password);
		return this;
	}
	
	public AdminUsersPage selectUserType(String usertype) {
		pageutility.dropDownValue(this.usertype, usertype);
		return this;
	}
	
	public AdminUsersPage saveNewUser() {
		savebutton.click();
		return this;
	}
	
	/*
	 * public void createNewUser(String username, String password, String usertype)
	 * { newbutton.click(); this.username.sendKeys(username);
	 * this.password.sendKeys(password); pageutility.dropDownValue(this.usertype,
	 * usertype); savebutton.click(); }
	 */

	public boolean isUserSavedAlertDisplayed() {
		return alert.isDisplayed();
	}
}
