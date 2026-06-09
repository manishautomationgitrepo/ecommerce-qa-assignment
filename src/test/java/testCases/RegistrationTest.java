package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.SignupPage;
import utilities.BaseTest;

public class RegistrationTest extends BaseTest {

	  @Test
	    public void verifyUserRegistration() {
		  
	        HomePage home = new HomePage(driver);
	        SignupPage signup = new SignupPage(driver);
	        AccountPage account = new AccountPage(driver);

	        Assert.assertTrue(home.isHomePageVisible());

	        home.clickSignupLogin();

	        signup.enterName("Manish");
	        signup.enterEmail(generateEmail());
	        signup.clickSignup();

	        signup.fillAccountDetails();

	        Assert.assertTrue(account.isAccountCreated());

	    }
        
	  
	    public static String generateEmail()
		{
			return RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
		}
}
