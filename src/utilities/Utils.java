package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Utils {
	
		public static WebDriver driver = null;
	
	//get the browser name from the test data sheet using the test case row number
	public static WebDriver openBrowser(int iTestCaseRow) throws Exception {
	
		String sBrowserName;
		
		try {
			sBrowserName = ExcelUtilities.getCellData(iTestCaseRow, Constant.Col_Browser);
			if(sBrowserName.equals("Chrome")) {
				
				System.setProperty("webdriver.chrome.driver", Constant.Path_ChromeBrowser);
				
				driver = new ChromeDriver();
				Log.info("Chrome driver instantiated");
			
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Log.info("Implecit wait for driver set to 20 seconds");
				
				driver.get(Constant.URL);
				Log.info("Target URL launched");
				
			}
		}catch (Exception e){
			Log.error("Class: Utilities | Method: OpenBrowser | Exception Desc: " + e.getMessage());
			throw e;// this was not included in the example
		}
		
		return driver;
		
	}
	//Get the test case name from the target test data sheet using the test case row number
	public static String getTestCaseName(String sTestCaseName) throws Exception {
		
		String val = sTestCaseName;
		
		try{
			int i = val.indexOf("@");
			val = val.substring(0,i);
			i = val.lastIndexOf(".");
			val = val.substring(i + 1);
			
			return val;
					
		}catch (Exception e){
			Log.error("Class:  Utilities  |  Method: getTestCaseName  |  Exception Desc: " + e.getMessage());
			throw (e);
			
		}
	}
	


}
