package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {

	HomePage homepage;
	ManageFooterTextPage footertext;
	@Test(description = "Verify that the footer text can be edited successfully")
	public void verifyEditFooterText() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin(username, password);

		String address = ExcelUtility.getStringData(1, 0, "footertext");
		String email = ExcelUtility.getStringData(1, 1, "footertext");
		int phone = ExcelUtility.getIntegerData(1, 2, "footertext");

		footertext = homepage.navigateToManageFooterTextPage();
		footertext.editFooterText_edit2(address, email, phone);

		boolean alertmessage = footertext.isUpdateAlertDisplayed();
		Assert.assertTrue(alertmessage, Constant.MANAGEFOOTERTEXTERROR);
	}
}
