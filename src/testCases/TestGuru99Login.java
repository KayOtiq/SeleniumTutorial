package testCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageObjects.Guru99HomePage;

import pageObjects.Guru99Login;


public class TestGuru99Login {
    WebDriver driver;

    Guru99Login objLogin;

    Guru99HomePage objHomePage;

    

    @BeforeTest

    public void setup(){

		String exePath = "C:\\SandboxLibraries\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/V4/");

    }

    /**

     * This test case will login in http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */

    @Test(priority=0)

    public void testHomePagePOM(){

        //Create Login Page object

    objLogin = new Guru99Login(driver);

    //Verify login page title

    String loginPageTitle = objLogin.getLoginTitle();

    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
    //login to application

    objLogin.loginToGuru99("mgr123", "mgr!23");

    // go the next page

    objHomePage = new Guru99HomePage(driver);

    //Verify home page

    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }
    
    @Test(priority=0)

    public void testHomePageFactory(){

        //Create Login Page object

    objLogin = new Guru99Login(driver);

    //Verify login page title

    String loginPageTitle = objLogin.getLoginTitle();

    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

    //login to application

    objLogin.loginToGuru99("mgr123", "mgr!23");

    // go the next page

    objHomePage = new Guru99HomePage(driver);

    //Verify home page

    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }
}
    
