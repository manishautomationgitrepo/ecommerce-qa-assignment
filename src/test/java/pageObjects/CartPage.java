package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By cartProduct = By.xpath("//tr[starts-with(@id, 'product')]");
	
	
	public boolean isProductAdded() {
        return WaitUtils.waitForVisible(driver, cartProduct).isDisplayed();
    }

}
