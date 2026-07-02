package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {

	/*
	 * @FindBy(xpath =
	 * "//a[contains(@href,'list-contact') and @class='small-box-footer']")
	 * WebElement moreinfo;
	 */
	@FindBy(css = "a.btn.btn-sm.btn.btn-primary.btncss")
	WebElement editbutton;
	@FindBy(css = "input#phone")
	WebElement phone;
	@FindBy(css = "input#email")
	WebElement email;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement address;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliverytime;
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement deliverychargelimit;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updatebutton;
	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement alert;

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void navigateToManageContactPage() { moreinfo.click(); }
	 */

	public void editContact(int phone, String email, String address, int deliverytime, int deliverychargelimit) {
		editbutton.click();

		// clearing necessary fields first
		this.phone.clear();
		this.email.clear();
		this.address.clear();
		this.deliverytime.clear();
		this.deliverychargelimit.clear();

		// updating with new info
		this.phone.sendKeys(String.valueOf(phone));
		this.email.sendKeys(email);
		this.address.sendKeys(address);
		this.deliverytime.sendKeys(String.valueOf(deliverytime));
		this.deliverychargelimit.sendKeys(String.valueOf(deliverychargelimit));

		//updatebutton.click();
		pageutility.clickUsingJavaScript(driver, updatebutton);
	}

	public boolean isUpdateAlertDisplayed() {
		return alert.isDisplayed();
	}
}
