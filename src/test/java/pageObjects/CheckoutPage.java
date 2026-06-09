package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class CheckoutPage {
	
WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
    By check_out_btn = By.xpath("//a[normalize-space()='Proceed To Checkout']");
    By place_order_btn = By.xpath("//a[contains(text(),'Place Order')]");
    By name_on_card = By.xpath("//input[@name='name_on_card']");
    By card_number = By.xpath("//input[@name='card_number']");
    By cvv_number = By.xpath("//input[@placeholder='ex. 311']");
    By expiry_month = By.xpath("//input[@placeholder='MM']");
    By expiry_year = By.xpath("//input[@placeholder='YYYY']");
    By pay_button  = By.xpath("//button[@id='submit']");
    By orderPlacedMessage = By.xpath("orderPlacedMessage");
    
    public void clickCheckOutBtn() {
    	WaitUtils.waitForClickable(driver, check_out_btn).click();
    }
    
    public void clickPlaceOrderBtn() {
    	WaitUtils.waitForClickable(driver, place_order_btn).click();
    }
    
    public void EnterNameOnCard(String CardName) {
    	driver.findElement(name_on_card).sendKeys(CardName);
    }
    
    public void EnterCardNumber(String CardNumber) {
    	driver.findElement(card_number).sendKeys(CardNumber);
    }
    
    public void EnterCVV(String cvv) {
    	driver.findElement(cvv_number).sendKeys(cvv);
    }
    
    public void EnterExpiryMonth(String month) {
    	driver.findElement(expiry_month).sendKeys(month);
    }
    
    public void EnterExpiryYear(String year) {
    	driver.findElement(expiry_year).sendKeys(year);
    }
    
    public void clickPayBtn() {
    	WaitUtils.waitForClickable(driver, pay_button).click();
    }
   
    public boolean isorderPlacedVisible() {
        return WaitUtils.waitForVisible(driver, orderPlacedMessage).isDisplayed();
    }
}
