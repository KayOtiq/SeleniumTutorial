package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appModules.SignIn;
import utilities.Constant;

public class GlobalVar_TC {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		// this to be put into a module to call the target browser
		String exePath = "C:\\SandboxLibraries\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
	
		//define variable
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
        driver.get(Constant.URL);
        SignIn.Execute(driver, Constant.Username, Constant.Password);
        System.out.println("Login Successful...");
        driver.quit();
        
        

	}

}
