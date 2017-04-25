package testCases;

import org.testng.annotations.Test;

import appModules.SignIn;
import utilities.BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BrowserFactory_TC {
  @Test
  public void SampleTest001() throws Exception{
	  //test that both browsers are actually only one instance of the chrome driver
	  
	  WebDriver driver = BrowserFactory.getBrowser("Chrome");
	  driver.get("http://toolsqa.com");
	  SignIn.Execute(driver);
	  
	  WebDriver driver1 = BrowserFactory.getBrowser("Chrome");
	  
	  if(driver.equals(driver1)){
		  System.out.println("The two Chrome browsers are the same");
	  }
			  
  }
  @AfterTest
  public void tearDown() {
	  BrowserFactory.closeAllDrivers();
	  
  }

}
