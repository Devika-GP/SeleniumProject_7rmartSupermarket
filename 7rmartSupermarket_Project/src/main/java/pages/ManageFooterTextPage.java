package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageFooterTextPage {

	@FindBy(xpath = "//a[contains(@href,'list-footertext') and @class='small-box-footer']")
	WebElement moreinfo;
	@FindBy(xpath = "//a[contains(@href,'edit=2')]")
	WebElement edit_2;
	@FindBy(css = "textarea#content")
	WebElement address;
	@FindBy(css = "input#email")
	WebElement email;
	@FindBy(css = "input#phone")
	WebElement phone;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updatebutton;
	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement alert;

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToManageFooterTextPage() {
		moreinfo.click();
	}

	public void editFooterText_edit2(String address, String email, int phone) {
		edit_2.click();

		// clearing all fields first
		this.address.clear();
		this.email.clear();
		this.phone.clear();

		// updating with new info
		this.address.sendKeys(address);
		this.email.sendKeys(email);
		this.phone.sendKeys(String.valueOf(phone));

		updatebutton.click();
	}

	public boolean isUpdateAlertDisplayed() {
		return alert.isDisplayed();
	}

}
