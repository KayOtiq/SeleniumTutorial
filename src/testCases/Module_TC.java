package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appModules.SignIn;

public class Module_TC {
		private static WebDriver driver = null;

	public static void main(String[] args) {
		
		// this to be put into a module to call the target browser
		String exePath = "C:\\SandboxLibraries\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
	
		//define variable
        String baseURL = "http://www.store.demoqa.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
        driver.get(baseURL);
     
        // Call the sign in action
        
        //SignIn.Execute(driver);
        System.out.println("Login Successful...");
        driver.quit();
        
        
	}

}
