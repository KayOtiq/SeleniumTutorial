package appModules;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ExcelUtilities;
import utilities.Log;

public class SignIn {
	
	public static void Execute(WebDriver driver) throws Exception{
		
		String sUsername = ExcelUtilities.getCellData(1, 1);
		Log.info("Username from test data is " + sUsername);
		
		String sPassword = ExcelUtilities.getCellData(1, 2);
		Log.info("Password from test data is " + sPassword);
			
		HomePage.linkMyAccount(driver).click();
		Log.info("My Account link click action performed");
		
		LoginPage.tbUsername(driver).sendKeys(sUsername);
		Log.info("Username entered into Username text box");
		
		LoginPage.tbPassword(driver).sendKeys(sPassword);
		Log.info("Password entered into password text box");
		
		LoginPage.btnLogin(driver).click();
		Log.info("Submit button clicked");
	
		}
	
	public static void Execute(WebDriver driver, String sUsername, String sPassword){
			
		HomePage.linkMyAccount(driver).click();
		Log.info("My Account link click action performed");
		
		LoginPage.tbUsername(driver).sendKeys(sUsername);
		Log.info("Username entered into Username text box");
		
		LoginPage.tbPassword(driver).sendKeys(sPassword);
		Log.info("Password entered into password text box");
		
		LoginPage.btnLogin(driver).click();
		Log.info("Submit button clicked");
	
	
		}
		


}
