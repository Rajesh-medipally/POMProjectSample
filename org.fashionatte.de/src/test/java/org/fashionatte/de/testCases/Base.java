package org.fashionatte.de.testCases;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.fashionatte.de.utilities.ReadConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.google.common.base.Function;

public class Base {
	
	public static WebDriver driver;
	public ReadConfig readConfig= new ReadConfig();
	public static Logger logger; 
	
	@BeforeClass
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.get(readConfig.getApplicationURL());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//setting up log files
		logger = Logger.getLogger("fashionatte");
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	/**
	 * below wait program is used specially to control the selenium until the page gets loaded.
	 * in our application the elements will load dynamically and response times are very dynamic in nature
	 * to handle i have written this wait program
	 * this program can be integrated into listeners afterwards. 
	 * just for current sample purpose i added it directly into main base class
	 * */
	public void pageLoaderWait() {
		 Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		    wait.until(new Function<WebDriver, Boolean>() {
		        public Boolean apply(WebDriver driver) {
		            System.out.println("Current Window State       : "
		                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
		            return String
		                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
		                .equals("complete");
		        }
		    });
		    
	}
	
	/**
	 * this is also an external wait to control the dynamic nature of elements. 
	 * when we create our own framework this can be handled internally
	 * */
	public void waitThread(int x) {
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
