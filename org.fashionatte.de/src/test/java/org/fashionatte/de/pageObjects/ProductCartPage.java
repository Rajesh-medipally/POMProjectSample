package org.fashionatte.de.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCartPage {
	WebDriver driver;
	
	public ProductCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//a[@class=\"cart__sum__voucher-link\"]")
	WebElement voucherLink;
	public void clickVoucherLink() {
		voucherLink.click();
	}
	
	
	@FindBy(xpath = "//input[@placeholder=\"Coupon\"]")
	WebElement voucherInput;
	public void enterVoucherValue() {
		voucherInput.sendKeys("qachallenge");
	}

	@FindBy(xpath = "//div[@class=\"btn-default btn--submit\"]")
	WebElement voucherSubmitButton;
	public void clickVoucherSubmitButton() {
		voucherSubmitButton.click();
	}

	@FindBy(xpath = "//th[@data-code=\"qachallenge\"]")
	WebElement voucherAfterApply;
	public boolean isVaoucherApplied() {
		return voucherAfterApply.isDisplayed();
	}
	
}
