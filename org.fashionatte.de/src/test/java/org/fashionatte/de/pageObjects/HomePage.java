package org.fashionatte.de.pageObjects;

import org.fashionatte.de.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	Utilities utilities;
	
	private WebElement acceptCookiesButton;
	private JavascriptExecutor jse;
	
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		 jse = (JavascriptExecutor) driver;
	}
		 
	public void clickAcceptCookies() {
	
		try {
			Thread.sleep(1000);
					
		    acceptCookiesButton = (WebElement)jse.executeScript("return document.querySelector(\"[id=usercentrics-root]\").shadowRoot.querySelector(\"[data-testid=uc-accept-all-button]\")");
		    acceptCookiesButton.click();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
	}
	
	
	
	
	@FindBy(xpath="//*[@class=\"search-container\"]")
     WebElement searchBox;	
	public WebElement getSearchBoxContainer() {
		
		return searchBox;
	}

	@FindBy(xpath = "//*[@class=\"search-bar-input\"]")
	WebElement searchBoxInput;
	public void enterIntoSearchBox(String text) {
		searchBoxInput.sendKeys(text);
	}

	@FindBy(xpath = "//*[@class=\"search-box-item\"][1]")
	WebElement shoes;
	public void clickshoes() {
		shoes.click();
	}
	
	@FindBy(xpath ="//a[@data-id=\"user login\"]")
	WebElement loginIcon;
	public void clickLoginIcon() {
		loginIcon.click();
	}
	
	
}
