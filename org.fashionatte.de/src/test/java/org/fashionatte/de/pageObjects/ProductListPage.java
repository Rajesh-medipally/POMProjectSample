package org.fashionatte.de.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
	WebDriver driver;
	public List<WebElement> list;
	
	
	public ProductListPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	/**
	 * This below code will be used after searching for an item
	 * This code will select all the resulted items element details and saves in list.
	 * to use this list we need to simply iterate it through until we find the match looking for
	 * the below iteration is to make sure list got more than one item if not it checks for elements for 4 times
	 * this practice is used to neglect the server side delays and to keep selenium busy.
	 * */
	
	public void selectOneItem(int x){
		
		for(int i=0; i<4;i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			list=driver.findElements(By.xpath("//div[@class=\"flex-grid__third\"]"));
			if(list.size()>1) break;
		}
		
		/**
		 * this method is to throw an error if we enter larger number than the available list of items
		 * in this practice, am using the value hard coded as one in test case but this method works more precisely 
		 * with dynamic entries.
		 * */
		if(x>list.size()) {
			try {
			throw new Exception("Entered item value is larger the available item list");
			}catch (Exception e) {
				System.out.println("Unhandled Exception from list");
			}
		}
		  list.get(x).click();
		
		
	}
}
