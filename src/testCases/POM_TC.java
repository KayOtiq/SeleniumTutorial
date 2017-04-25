package testCases;

//demo of logging in and out of target page

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class POM_TC {
	
	public static WebDriver driver = null;

	public static void main(String[] args) {
		
		String exePath = "C:\\SandboxLibraries\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
	
		//define variable
        String baseURL = "http://www.store.demoqa.com";
        //Open the browser at the target URL       
        driver.get(baseURL);
        //set the implicit wait time to 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //access the page object library
        
        HomePage.linkMyAccount(driver).click();
        LoginPage.tbUsername(driver).sendKeys("testuser_1");
        LoginPage.tbPassword(driver).sendKeys("Test@123");
        LoginPage.btnLogin(driver).click();
        
        System.out.println(" Login Successful...");
       // HomePage.linkLogout(driver).click();
        driver.quit();
        
        
	}

}
