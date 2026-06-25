package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(description = "Verify that a user can successfully log in with a valid username and valid password", groups={"Regression"})
	public void verifyValidUsernameAndValidPassword() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin(username, password);

		boolean dashboard = loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashboard, Constant.VALIDLOGINERROR);
	}

	@Test(description = "Check whether the system prevents login with valid username and invalid password")
	public void verifyValidUsernameAndInvalidPassword() throws IOException {

		String username = ExcelUtility.getStringData(2, 0, "loginpage");
		String password = ExcelUtility.getStringData(2, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin(username, password);

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.INVALIDLOGINERROR);
	}

	@Test(description = "Check whether the system prevents login with invalid username and valid password")
	public void verifyInvalidUsernameAndValidPassword() throws IOException {

		String username = ExcelUtility.getStringData(3, 0, "loginpage");
		String password = ExcelUtility.getStringData(3, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin(username, password);

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.INVALIDLOGINERROR);
	}

	@Test(description = "Check whether the system prevents login with invalid username and invalid password")
	public void verifyInvalidUsernameAndInvalidPassword() throws IOException {

		String username = ExcelUtility.getStringData(4, 0, "loginpage");
		String password = ExcelUtility.getStringData(4, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin(username, password);

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.INVALIDLOGINERROR);
	}
}
