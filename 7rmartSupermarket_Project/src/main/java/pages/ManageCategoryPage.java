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
	@FindBy(xpath = "//a[contains(@href,'list-category') and @class='small-box-footer']")
	WebElement moreinfo;
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
	
	public void navigateToManageCategoryPage() {
		moreinfo.click();
	}
	
	public void createNewCategory(String category) {
		newbutton.click();		
		categoryname.sendKeys(category);
		pageutility.clickUsingJavaScript(driver, selectgroup);
		fileuploadutility.fileUploadUsingSendkeys(fileselect, Constant.CATEGORYIMAGEFILE);
		waitutility.waitForElementToBeClickable(driver, savebutton);
		pageutility.clickmethod(driver, savebutton);
	}
	
	public boolean isCategorySavedAlertDisplayed() {
		return alert.isDisplayed();
	}
}
