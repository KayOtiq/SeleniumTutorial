package testCases;

import org.testng.annotations.Test;

import appModules.SignIn;

import org.testng.annotations.BeforeMethod;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import utilities.*;


public class UDF_TC {
	
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
  @Test
  public void main() throws Exception {
	  SignIn.Execute(driver);
	  System.out.println("Login Successful...");
	  		
  }
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  DOMConfigurator.configure("log4j.xml");
	  sTestCaseName = this.toString();
	  sTestCaseName = Utils.getTestCaseName(this.toString());
	  Log.startTestCase(sTestCaseName);
	  ExcelUtilities.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
	  iTestCaseRow = ExcelUtilities.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
	  
	  driver = Utils.openBrowser(iTestCaseRow);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
