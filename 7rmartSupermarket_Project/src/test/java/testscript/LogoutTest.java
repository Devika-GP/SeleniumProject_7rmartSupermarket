package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {

	@Test(description="Verify that a logged-in user can log out successfully", groups={"Regression"})
	public void verifySuccessfulLogout() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin(username, password);

		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickDropDownMenu(driver);
		logoutpage.clickLogoutButton();

		boolean signinbutton = logoutpage.isSigninButtonDisplayed();
		Assert.assertTrue(signinbutton, Constant.LOGOUTERROR);
	}
}
