package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base {

	HomePage homepage;
	ManageCategoryPage category;
	@Test(description = "Verify that a new category/product can be added successfully with its image")
	public void verifyNewCategoryCreation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin(username, password);
		
		FakerUtility fakerutility = new FakerUtility();
		String categoryname = fakerutility.generateCategory();

		category = homepage.navigateToManageCategoryPage();
		//category.createNewCategory(categoryname);
		category.clickNewButton().enterCategoryName(categoryname).selectGroup(driver).uploadImageFile().clickSaveButton(driver);

		boolean alertmessage = category.isCategorySavedAlertDisplayed();
		Assert.assertTrue(alertmessage, Constant.MANAGECATEGORYERROR);
	}
}
