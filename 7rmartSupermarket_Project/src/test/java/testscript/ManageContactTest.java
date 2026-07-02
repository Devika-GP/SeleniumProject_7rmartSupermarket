package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {

	HomePage homepage;
	ManageContactPage contact;
	@Test(description = "Verify that contact information can be edited successfully")
	public void verifyEditContact() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin(username, password);

		int phone = ExcelUtility.getIntegerData(1, 0, "contactpage");
		String email = ExcelUtility.getStringData(1, 1, "contactpage");
		String address = ExcelUtility.getStringData(1, 2, "contactpage");
		int deliverytime = ExcelUtility.getIntegerData(1, 3, "contactpage");
		int deliverychargelimit = ExcelUtility.getIntegerData(1, 4, "contactpage");

		contact = homepage.navigateToManageContactPage();
		contact.editContact(phone, email, address, deliverytime, deliverychargelimit);

		boolean alertmessage = contact.isUpdateAlertDisplayed();
		Assert.assertTrue(alertmessage, Constant.MANAGECONTACTERROR);
	}

}
