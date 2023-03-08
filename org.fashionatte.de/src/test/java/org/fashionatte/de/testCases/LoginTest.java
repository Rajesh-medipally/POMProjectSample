package org.fashionatte.de.testCases;

import java.io.IOException;

import org.fashionatte.de.pageObjects.HomePage;
import org.fashionatte.de.pageObjects.LoginPage;
import org.fashionatte.de.utilities.XLUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



/**
 * This class will have test details about logging into the application
 * 
 * Test Scenario: log into the application with valid given details.
 * Test Procedure
 * 1.Verify the username field
 * 2.Verify the password field
 * 3.Login using valid details
 * 
 * NOTE: because it is a sample framework, i am only including the valid login, 
 * not including the negative of edge case testings. 
 * 
 * NOTE: the login details are stored in a file src/test/java/org/fashionatte/de/testData/LoginData.xlsx
 * in this login test used data providers which takes data from an excel file and test. 
 * * */
public class LoginTest extends Base{
	
	HomePage homepage;
	LoginPage loginpage;
	
	@BeforeClass
	public void setup() {
		homepage = new HomePage(driver);
		loginpage= new LoginPage(driver);
		pageLoaderWait();
		homepage.clickAcceptCookies();
		homepage.clickLoginIcon();
		
	}
	
	
	/**
	 * the below test will take the data from excel file using data provider 
	 * and runs the test, depending on the how many test data were given
	 * the method will go in iteration until the test data gets over
	 * */
	@Test(dataProvider = "LoginData")
	public void login(String username, String password) {
	
		
		if((username=="")||(password=="")) {
			logger.info("Empty spaces are entered ");
		}
		else {
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.enterSubmitButton();
		pageLoaderWait();
		logger.info("Login : Entered username "+username+" password "+ password);		
		driver.navigate().refresh();
		pageLoaderWait();
		}
	}
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
	String path = System.getProperty("user.dir")+"\\src\\test\\java\\org\\fashionatte\\de\\testData\\LoginData.xlsx";
		
	int rowcount = XLUtils.getRowCount(path, "Sheet1");
	int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
	
	String loginData[][] = new String[rowcount][colcount];
	for(int i=1;i<=rowcount;i++) {
		for(int j=0; j<colcount;j++) {
			loginData[i-1 ][j]=XLUtils.getCellData(path, "Sheet1", i,j);
			
		}
		}
	return loginData;
	}
	

}
