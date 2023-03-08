package org.fashionatte.de.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPage {
	
	WebDriver driver;
	public ProductDescriptionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	/**
	 * as we are dealing with shoes in this sample program.
	 * the majority element to choose is size
	 * so from the xpath am selecting here index 3
	 * we can also make this more dynamic by having details pre-handed. (means we can select any size)
	 * */
	@FindBy(xpath = "//*[@class=\"size-selector__item\"][3]")
	WebElement size;
	public void completeSizeSelection() {
		size.click();
	}
	
	/**
	 * the below code will add the selected item into the cart
	 * */
	@FindBy(xpath = "//*[@class=\"btn btn--bigger-icon preventspinner btn-default\"]")
	WebElement addToCartButton;
	public void enterAddToCartButton() {
		addToCartButton.click();
	}
	
	
	@FindBy(xpath = "//*[@class=\"header__cart-icon\"]")
	WebElement cartIcon;
	public void clickCart() {
		cartIcon.click();
	}

}
