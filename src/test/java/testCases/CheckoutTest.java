package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import utilities.BaseTest;

public class CheckoutTest extends BaseTest{
	
	@Test(dependsOnMethods = "testCases.AddToCartTest.verifyAddToCart")
	public void verifyCheckoutProcess()
	{
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		
		checkoutPage.clickCheckOutBtn();
		checkoutPage.clickPlaceOrderBtn();
		checkoutPage.EnterNameOnCard("Manish Arya");
		checkoutPage.EnterCardNumber("1234567890");
		checkoutPage.EnterCVV("123");
		checkoutPage.EnterExpiryMonth("12");
		checkoutPage.EnterExpiryYear("2026");
		checkoutPage.clickPayBtn();
		
		Assert.assertTrue(checkoutPage.isorderPlacedVisible(),"Order was not placed successfully");
		
		
	}

}
