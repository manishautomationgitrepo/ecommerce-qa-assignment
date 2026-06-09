package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class AccountPage {
	
	WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
        this.driver=driver;	
	}
	
	By accountCreated = By.xpath("//b[text()='Account Created!']");
    By accountLoggedIn = By.xpath("//b[normalize-space()='Manish']");

    
    public boolean isAccountCreated() {
        return WaitUtils.waitForVisible(driver, accountCreated).isDisplayed();
    }
    
    public boolean isAccountLoggedIn()
    {
    	return WaitUtils.waitForVisible(driver, accountLoggedIn).isDisplayed();
    }
}
