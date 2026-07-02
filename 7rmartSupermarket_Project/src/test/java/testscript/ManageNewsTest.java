package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	HomePage homepage;
	ManageNewsPage managenews;
	@Test(description = "“Verify that a new news item can be created successfully")
	public void verifyNewNewsCreation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		homepage = loginpage.verifyLogin(username, password);

		String news = ExcelUtility.getStringData(0, 1, "newspage");
		managenews = homepage.navigateToManageNews();
		managenews.createNewNewsItem(news);

		boolean alertmessage = managenews.isNewsSavedAlertDisplayed();
		Assert.assertTrue(alertmessage, Constant.MANAGENEWSERROR);
	}

}
