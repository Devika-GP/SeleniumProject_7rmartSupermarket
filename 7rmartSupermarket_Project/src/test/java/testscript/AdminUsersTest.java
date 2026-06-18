package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {

	@Test(description = "Verify that a new user can be created successfully")
	public void verifyNewAdminUserCreation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin(username, password);

		String adminusername = ExcelUtility.getStringData(1, 0, "adminusers");
		String adminpassword = ExcelUtility.getStringData(1, 1, "adminusers");
		String usertype = ExcelUtility.getStringData(1, 2, "adminusers");

		AdminUsersPage adminpage = new AdminUsersPage(driver);
		adminpage.navigateToAdminUsers();
		adminpage.createNewUser(adminusername, adminpassword, usertype);

		boolean alertmessage = adminpage.isUserSavedAlertDisplayed();
		Assert.assertTrue(alertmessage);
	}
}
