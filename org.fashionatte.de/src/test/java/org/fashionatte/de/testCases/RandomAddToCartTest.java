package org.fashionatte.de.testCases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.fashionatte.de.pageObjects.HomePage;
import org.fashionatte.de.pageObjects.ProductCartPage;
import org.fashionatte.de.pageObjects.ProductDescriptionPage;
import org.fashionatte.de.pageObjects.ProductListPage;
import org.fashionatte.de.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Framework Strategy: we are using Page Object Model (POM) for the automation framework
 * This class will perform the test procedure for adding an item to cart and applying coupon to it.
 * Test Plan : add an item to cart and apply coupon
 * Test Procedure:
 * 1.Enter into homepage
 * 2.Search for item (shoes)
 * 3.Select one item from results page(shoes)
 * 4.Select the desired sizes (shoe size)
 * 5.Add to cart
 * 6.Go to the cart
 * 7.Apply coupon
 * 8.Goto Billing and end task.
 * 
 * Test Cases :
 * 1. Enter into homepage
 * =>Verify the HomePage is landed
 * =>Accept Cookies
 * 2.Search for item (shoes)
 * =>Verify Search box is eanbled
 * =>Enter Search value and select the item from list
 * 3. Complete an items selection process
 * => Verify the page is landed correctly
 * => Select one item from the list
 * 4. Select the item's Requirements
 * => select all the options needed to be checked to proceed (until the add to cart option enables)
 * => add the item to the cart
 * 5. Select Voucher and terminate
 * => Verify the page 
 * => apply the voucher
 * => make sure voucher added successfully
 * => Quite the driver
 * */

/**
 * Special NOTE: due to time constrains test cases are written as a single entity inside 
 * by taking test procedures as main test methods 
 * */

public class RandomAddToCartTest extends Base {
	HomePage homepage;
	ProductListPage productListPage;
	ProductDescriptionPage productDescriptionPage;
	ProductCartPage productCartPage;
	
	@BeforeClass
	public void setup() {
		 homepage= new HomePage(driver);
		 productListPage= new ProductListPage(driver);
		 productDescriptionPage= new ProductDescriptionPage(driver);
		 productCartPage = new ProductCartPage(driver);
	}
	
	
	
	
	@Test(priority = 0)
	public void enterIntoHomePage() {
		/**this assertion will make sure we landed on homepage by verifying the title. 
		 * the title of the homepage is saved in configurations/config.properties folder
		 * and it is being accessed by readconfig class.
		 * this process is used for simplifying accessibility of the hard coded values
		*/
		Assert.assertEquals(driver.getTitle(), readConfig.getHomePageTitle());
		logger.info("Homepage is successfully landed");
		/**
		 * below code will accepts the cookies.
		 * */
		homepage.clickAcceptCookies();
		logger.info("cookies are successfully accepted");
	}
	
	
	/**
	 * below test will verify the search box and enters shoes into search and selects the shoes option.
	 * "shoes" is hard coded here, we can save it in sample xml or excel files for future reference 
	 * */
	@Test(priority = 1)
	public void searchForItem() {
		/**
		 * below code checks for search box is enabled or not
		 * */
		pageLoaderWait();
		Assert.assertTrue(homepage.getSearchBoxContainer().isEnabled());
		logger.info("search box is checked for enability ");
		/**
		 * below code moves the mouse pointer to the searchbox and performs the click action
		 */
		Actions a = new Actions(driver);
		a.moveToElement(homepage.getSearchBoxContainer()).click().build().perform();
		logger.info("click action is being performed on search box");
		/**
		 * below code enters Shoes into search box 
		 */
		homepage.enterIntoSearchBox("Shoes");
		logger.info("search iterm shoes is entered into search box");
		/**
		 * below code selects the first index result of the search
		 * index is been selected in the xpath. 
		 * to understand navigate back to clickshoes() method and observe the xpath
		 * the selection is being hardcoded because currently dont have the access for search API. :)
		 */
		waitThread(500);
		homepage.clickshoes();
		logger.info("option shoes is been clicked from the search options list");
	}
	
	@Test(priority = 2)
	public void completeAnItemsSelectionProcess(){
		pageLoaderWait();
		
		/**
		 * this below code will verify the landing of the page with its titles. 
		 * */
		if(driver.getTitle().equals(readConfig.getProductListingPageTitle1())||(driver.getTitle().equals(readConfig.getProductListingPageTitle2()))) {
		Assert.assertTrue(true);	
		}else {
			Assert.assertFalse(true);
		}				
		logger.info("Product listing page landed successfully");
		/**
		 * below code will select an item from the list
		 * for convenience purpose i have listed item number 2. (in index it is 1)
		 * to understand more about please go through the selectOneItem() method
		 * */
		productListPage.selectOneItem(1);
		logger.info("one item is being selected from the product listing page");
	}
	
	
	
	@Test(priority = 3)
	public void selectItemsRequirements() {
		pageLoaderWait();
		/**
		 * below method completes the size selection for shoes. 
		 * doing necessary things to enable add to cart option
		 * */
		productDescriptionPage.completeSizeSelection();
		logger.info("shoes size selection is being completed");
		productDescriptionPage.enterAddToCartButton();
		logger.info("Add to cart button is being verified and clicked, the item added to cart");
		productDescriptionPage.clickCart();
		logger.info("cart option is clicked to open the cart page");
	}

	@Test(priority = 4)
	public void completeVoucherProcess() {
		pageLoaderWait();
		
		productCartPage.clickVoucherLink();
		logger.info("voucher link is being clicked");
		productCartPage.enterVoucherValue();
		logger.info("voucher qachallenge is been entered");
		productCartPage.clickVoucherSubmitButton();
		logger.info("voucher is been submitted");
		Assert.assertTrue(productCartPage.isVaoucherApplied());
		logger.info("voucher is successfully applied");
	}
	
	
}
