package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	@FindBy(xpath = "//a[contains(@href,'list-news') and @class='small-box-footer']")
	WebElement moreinfo;
	@FindBy(css = "a.btn.btn-rounded.btn-danger")
	WebElement newbutton;
	@FindBy(css = "textarea#news")
	WebElement textarea;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement alert;

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToManageNews() {
		moreinfo.click();
	}

	public void createNewNewsItem(String news) {
		newbutton.click();
		textarea.sendKeys(news);
		savebutton.click();
	}

	public boolean isNewsSavedAlertDisplayed() {
		return alert.isDisplayed();
	}
}
