package utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

// Use to get target browser without issue of incorrectly implemented driver instances.  

public class BrowserFactory {

 
		private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	 
		/*
		 * Factory method for getting browsers
		 */
		public static WebDriver getBrowser(String browserName) {
			WebDriver driver = null;
	 
			switch (browserName) {
			case "Firefox":
				driver = drivers.get("Firefox");
				if (driver == null) {
					driver = new FirefoxDriver();
					drivers.put("Firefox", driver);
				}
				break;
			case "IE":
				driver = drivers.get("IE");
				if (driver == null) {
					System.setProperty("webdriver.ie.driver", Constant.Path_IEBrowser);
					DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
					ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
					 driver = new InternetExplorerDriver(ieCapabilities);
					drivers.put("IE", driver);
					
				}
				break;
			case "Chrome":
				driver = drivers.get("Chrome");
				if (driver == null) {
					
					System.setProperty("webdriver.chrome.driver", Constant.Path_ChromeBrowser);
					driver = new ChromeDriver();
					drivers.put("Chrome", driver);
				}
				break;
			}
			return driver;
		}
		
		public static void closeAllDrivers() {
			for (String key : drivers.keySet()) {
				drivers.get(key).close();
				drivers.get(key).quit();
			}
		}

}
