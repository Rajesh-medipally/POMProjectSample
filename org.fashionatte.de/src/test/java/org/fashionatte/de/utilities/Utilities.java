package org.fashionatte.de.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	WebDriver driver;
	
	public Utilities(WebDriver driver) {
		this.driver=driver;
	}
	
	public  void waitForElement(WebElement element,int x) {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(x));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(x));
				wait.until(ExpectedConditions.visibilityOf(element));
	} 
}
