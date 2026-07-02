package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	HomePage homepage;
	AdminUsersPage adminpage;
	@Test(description = "Verify that a new user can be created successfully", retryAnalyzer=retry.Retry.class)
	public void verifyNewAdminUserCreation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin(username, password);

		FakerUtility fakerutility = new FakerUtility();
		String adminusername = fakerutility.generateUsername();
		String adminpassword = ExcelUtility.getStringData(1, 1, "adminusers");
		String usertype = ExcelUtility.getStringData(1, 2, "adminusers");

		adminpage = homepage.navigateToAdminUsers();
		adminpage.clickNewButton().enterUsername(adminusername).enterPassword(adminpassword).selectUserType(usertype).saveNewUser();
		///adminpage.createNewUser(adminusername, adminpassword, usertype);

		boolean alertmessage = adminpage.isUserSavedAlertDisplayed();
		Assert.assertTrue(alertmessage, Constant.ADMINUSERPAGEERROR);
	}
}
