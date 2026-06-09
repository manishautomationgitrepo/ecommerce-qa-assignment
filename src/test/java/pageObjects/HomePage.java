package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class HomePage {
	
	WebDriver driver;
	
	By homeLogo = By.xpath("//img[@alt='Website for automation practice']");
    By signupLoginBtn = By.cssSelector("a[href='/login']");
    By productsMenu = By.xpath("//a[@href='/product_details/1']");
    By addToCartBtn = By.xpath("//button[normalize-space()='Add to cart']");
    By viewCartLink = By.xpath("viewCartLink");
    By continueShopingbtn = By.xpath("//button[normalize-space()='Continue Shopping']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageVisible() {
        return WaitUtils.waitForVisible(driver, homeLogo).isDisplayed();
    }

    public void clickSignupLogin() {
    	WaitUtils.waitForClickable(driver, signupLoginBtn).click();
    }
    
    public void clickProducts() {
        WaitUtils.waitForClickable(driver, productsMenu).click();
    }

    public void addProductToCart() {
        WaitUtils.waitForClickable(driver, addToCartBtn).click();
    }
    
    public void clickContinueShopping()
    {
    	WaitUtils.waitForClickable(driver, continueShopingbtn).click();
    }
    
    public void openCart() {
        WaitUtils.waitForClickable(driver, viewCartLink).click();
    }
}	
