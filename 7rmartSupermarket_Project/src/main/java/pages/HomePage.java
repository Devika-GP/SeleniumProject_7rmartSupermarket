package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement dropdownbutton;
	@FindBy(css = "i.ace-icon.fa.fa-power-off")
	WebElement logoutbutton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinbutton;
	
	//chaining concept
	@FindBy(xpath = "//a[contains(@href,'list-news') and @class='small-box-footer']")
	WebElement managenewsmoreinfo;
	
	@FindBy(xpath = "//a[contains(@href,'list-contact') and @class='small-box-footer']")
	WebElement managecontactmoreinfo;
	
	@FindBy(xpath = "//a[contains(@href,'list-admin') and @class='small-box-footer']")
	WebElement adminusermoreinfo;
	
	@FindBy(xpath = "//a[contains(@href,'list-category') and @class='small-box-footer']")
	WebElement managecategorymoreinfo;
	
	@FindBy(xpath = "//a[contains(@href,'list-footertext') and @class='small-box-footer']")
	WebElement managefootertextmoreinfo;

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ManageNewsPage navigateToManageNews() {
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	
	public ManageContactPage navigateToManageContactPage() {
		managecontactmoreinfo.click();
		return new ManageContactPage(driver);
	}
	
	public AdminUsersPage navigateToAdminUsers() {
		adminusermoreinfo.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageCategoryPage navigateToManageCategoryPage() {
		managecategorymoreinfo.click();
		return new ManageCategoryPage(driver);
	}
	
	public ManageFooterTextPage navigateToManageFooterTextPage() {
		managefootertextmoreinfo.click();
		return new ManageFooterTextPage(driver);
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
