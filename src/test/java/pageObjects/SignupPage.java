package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtils;

public class SignupPage {
	
	WebDriver driver;
	
	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By name = By.name("name");
    By email = By.cssSelector("[data-qa='signup-email']");
    By signupBtn = By.cssSelector("[data-qa='signup-button']");
    
    public void enterName(String username) {
        driver.findElement(name).sendKeys(username);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void clickSignup() {
        WaitUtils.waitForClickable(driver, signupBtn).click();
    }

    public void fillAccountDetails() {
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("Test@123");

        new Select(driver.findElement(By.id("days"))).selectByVisibleText("18");
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("April");
        new Select(driver.findElement(By.id("years"))).selectByVisibleText("1999");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("first_name")).sendKeys("Manish");
        driver.findElement(By.id("last_name")).sendKeys("Arya");

        driver.findElement(By.id("address1")).sendKeys("Test Address");
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");

        driver.findElement(By.id("state")).sendKeys("MP");
        driver.findElement(By.id("city")).sendKeys("Gwalior");
        driver.findElement(By.id("zipcode")).sendKeys("474001");
        driver.findElement(By.id("mobile_number")).sendKeys("9999999999");

        driver.findElement(By.cssSelector("[data-qa='create-account']")).click();
    }
}
