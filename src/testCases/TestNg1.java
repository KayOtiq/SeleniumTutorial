package testCases;

import org.testng.annotations.Test;

//import utilities.Constant;
import utilities.Log;

//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestNg1 {
	
	public WebDriver driver;
	
  @Test
  public void main() {
	  
		// Find the element that's ID attribute is 'account'(My Account)
	  
      driver.findElement(By.id("account")).click();
 
      // Find the element that's ID attribute is 'log' (Username)
 
      // Enter Username on the element found by above desc.
 
      driver.findElement(By.id("log")).sendKeys("testuser_1");
 
      // Find the element that's ID attribute is 'pwd' (Password)
 
      // Enter Password on the element found by the above desc.
 
      driver.findElement(By.id("pwd")).sendKeys("Test@123");
 
      // Now submit the form. WebDriver will find the form for us from the element
 
      driver.findElement(By.id("login")).click();
 
      // Print a Log In message to the screen
 
      System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
 
      // Find the element that's ID attribute is 'account_logout' (Log Out)
 
      //driver.findElement(By.id("account_logout"));
  }
  
  @BeforeTest
  public void beforeTest() {
	  
		//Provide Log4j configuration settings
		
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Selenium Test:  TestNG_Framework"); //name the start of the test log
		
		// this to be put into a module to call the target browser
		String exePath = "C:\\SandboxLibraries\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		//WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		Log.info("Chrome driver instantiated");
	
		//define variable
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Log.info("Implecit wait for driver set to 10 seconds");
   
    driver.get("http://Store.DemoQA.com");
    Log.info("Test browser opened");
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
