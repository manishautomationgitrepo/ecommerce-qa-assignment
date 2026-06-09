package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import utilities.BaseTest;

public class AddToCartTest extends BaseTest{

	@Test(dependsOnMethods = "testCases.LoginTest.verifyLogin")
	public void verifyAddToCart() {

        HomePage home = new HomePage(driver);
        
        home.clickProducts();
        home.addProductToCart();
        home.clickContinueShopping();
        home.openCart();
        
        CartPage cartPage=new CartPage(driver);

        Assert.assertTrue(cartPage.isProductAdded(),"Product was not added to cart");
    }
}
