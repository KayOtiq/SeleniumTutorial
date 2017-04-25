package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Log;

public class LoginPage {

		private static WebElement element = null;
	
	public static WebElement tbUsername(WebDriver driver) {
		element = driver.findElement(By.id("log"));
		Log.info("Username text box found");
		return element;
		
	}
	
	public static WebElement tbPassword(WebDriver driver){
		element = driver.findElement(By.id("pwd"));
		Log.info("Password text box found");
		return element;
	}
	
	public static WebElement btnLogin(WebDriver driver){
		element = driver.findElement(By.id("login"));
		Log.info("Submit Button found");
		return element;
		
	}
	
}
