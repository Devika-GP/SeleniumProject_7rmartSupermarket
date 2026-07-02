package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	/*
	 * @FindBy(xpath =
	 * "//a[contains(@href,'list-category') and @class='small-box-footer']")
	 * WebElement moreinfo;
	 */
	@FindBy(css = "a.btn.btn-rounded.btn-danger")
	WebElement newbutton;
	@FindBy(xpath = "//input[@name='category']")
	WebElement categoryname;
	//@FindBy(css = "li.ms-elem-selectable.ms-hover")
	@FindBy(xpath="(//span[text()='discount'])[1]")
	WebElement selectgroup;
	@FindBy(css="input#main_img")
	WebElement fileselect;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement alert;
	
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	FileUploadUtility fileuploadutility = new FileUploadUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * public void navigateToManageCategoryPage() { moreinfo.click(); }
	 */
	
	public ManageCategoryPage clickNewButton() {
		newbutton.click();
		return this;
	}
	
	public ManageCategoryPage enterCategoryName(String category) {
		categoryname.sendKeys(category);
		return this;
	}
	
	public ManageCategoryPage selectGroup(WebDriver driver) {
		pageutility.clickUsingJavaScript(driver, selectgroup);
		return this;
	}
	
	public ManageCategoryPage uploadImageFile() {
		fileuploadutility.fileUploadUsingSendkeys(fileselect, Constant.CATEGORYIMAGEFILE);
		return this;
	}
	
	public ManageCategoryPage clickSaveButton(WebDriver driver) {
		waitutility.waitForElementToBeClickable(driver, savebutton);
		pageutility.clickUsingJavaScript(driver, savebutton);
		return this;
	}
	
	public boolean isCategorySavedAlertDisplayed() {
		return alert.isDisplayed();
	}
}
