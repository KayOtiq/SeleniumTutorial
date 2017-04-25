package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Log;

 public class HomePage {
	
	private static WebElement element = null;
	//WebDriver driver;
	

	
public static WebElement linkMyAccount(WebDriver driver){
	
	element = driver.findElement(By.xpath(".//*[@id='account']/a"));
	Log.info("My Account link element found");
	
	return element;
	
	}

public static WebElement linkLogout(WebDriver driver){
	
	element = driver.findElement(By.id("account_logout"));
	Log.info("Log out link element found");
	
	return element;
}

}
