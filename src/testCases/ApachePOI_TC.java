package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appModules.SignIn;
import appModules.SignIn2;
import utilities.Constant;
import utilities.ExcelUtilities;

public class ApachePOI_TC {
	
		private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		ExcelUtilities.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		
		// this to be put into a module to call the target browser
		String exePath = "C:\\SandboxLibraries\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
	
		//define variable
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
        driver.get(Constant.URL);
        SignIn2.Execute(driver);
        System.out.println("Successfully logged in...");
        driver.quit();
        
        ExcelUtilities.setCellData("Pass",1,3);
        
	}

}
