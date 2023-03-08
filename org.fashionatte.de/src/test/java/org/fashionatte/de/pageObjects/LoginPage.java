package org.fashionatte.de.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement email;
	public void enterUserName(String username) {
		email.clear();
		email.sendKeys(username);
	}
	
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;
	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	@FindBy(xpath = "//div[@class=\"login__password--forgot\"]/following-sibling::div/following-sibling::div/div/child::button")
	WebElement submitButton;
	public void enterSubmitButton() {
		submitButton.click();
	}
	
	
	@FindBy(xpath = "//div[@id=\"email-error\"]")
	WebElement emailError;
	public boolean isEmailErrorPresent() {
		return emailError.isEnabled();
//		return emailError.isDisplayed();
	}
	
	@FindBy(xpath = "//div[@id=\"password-error\"]")
	WebElement passwordError;
	public boolean ispasswordErrorPresent() {
		return passwordError.isDisplayed();
	}
	
	
}
