package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appModules.SignIn2;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;

public class Log4jLogging_TC {
	
		private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		//Provide Log4j configuration settings
		
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Selenium Test:  Log4Logging TC"); //name the start of the test log
		
		ExcelUtilities.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		Log.info("Excel data sheet opened");
		
		// this to be put into a module to call the target browser
		String exePath = "C:\\SandboxLibraries\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		Log.info("Chrome driver instantiated");
	
		//define variable
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log.info("Implecit wait for driver set to 10 seconds");
       
        driver.get(Constant.URL);
        Log.info("Test browser opened");
        SignIn2.Execute(driver);
        
        System.out.println("Successfully logged in...");
        driver.quit();
        Log.info("Browser closed");
        
        ExcelUtilities.setCellData("Pass",1,3);
        Log.info("Test results logged");
        Log.endTestCase("Log4Logging TC");
	}

}
