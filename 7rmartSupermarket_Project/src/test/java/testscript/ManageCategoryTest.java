package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base {

	@Test(description = "Verify that a new category/product can be added successfully with its image")
	public void verifyNewCategoryCreation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin(username, password);

		//String categoryname = ExcelUtility.getStringData(1, 0, "categorypage");
		
		FakerUtility fakerutility = new FakerUtility();
		String categoryname = fakerutility.generateCategory();
		
		ManageCategoryPage category = new ManageCategoryPage(driver);
		category.navigateToManageCategoryPage();
		category.createNewCategory(categoryname);

		boolean alertmessage = category.isCategorySavedAlertDisplayed();
		Assert.assertTrue(alertmessage);
	}
}
