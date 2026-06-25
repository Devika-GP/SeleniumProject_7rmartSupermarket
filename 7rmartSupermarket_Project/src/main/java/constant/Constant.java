package constant;

public class Constant {
	public static final String TESTDATAFILE = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\TestData_7martProject.xlsx";

	public static final String CATEGORYIMAGEFILE = System.getProperty("user.dir") + "\\src\\test\\resources\\spices.png";
	
	public static final String CONFIGFILE = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
	
	public static final String VALIDLOGINERROR = "Home page not loaded with valid credentials!";
	
	public static final String INVALIDLOGINERROR = "Login fail alert not displayed!";
	
	public static final String ADMINUSERPAGEERROR = "Error creating new user! Alert not displayed!";
	
	public static final String LOGOUTERROR = "Logged out user not redirected to Login page!";
	
	public static final String MANAGECATEGORYERROR = "Error in creating new category. Alert not displayed!";
	
	public static final String MANAGECONTACTERROR = "Error in updating contact details. Alert not displayed!";
	
	public static final String MANAGEFOOTERTEXTERROR = "Error in updating footer text fields. Alert not displayed!";
	
	public static final String MANAGENEWSERROR = "Error in creating new news item. Alert not displayed!";
}
