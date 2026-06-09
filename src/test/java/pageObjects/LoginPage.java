package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Email = By.xpath("//input[@data-qa='login-email']");
	By Password = By.xpath("//input[@placeholder='Password']");
	By LoginBtn = By.xpath("//button[normalize-space()='Login']");
	
	public void enterEmail(String email)
	{
		driver.findElement(Email).sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(Password).sendKeys(password);
	}
	
	public void clickLogin()
	{
		WaitUtils.waitForClickable(driver, LoginBtn).click();
	}
	
	

}
