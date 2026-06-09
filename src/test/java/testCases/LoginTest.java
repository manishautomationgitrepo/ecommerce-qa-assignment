package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.BaseTest;

public class LoginTest extends BaseTest {
	
	@Test
	public void verifyLogin()
	{
		HomePage home=new HomePage(driver);
		Assert.assertTrue(home.isHomePageVisible());
		home.clickSignupLogin();
		
		LoginPage login=new LoginPage(driver);
		login.enterEmail(prop.getProperty("email"));
		login.enterPassword(prop.getProperty("password"));
		login.clickLogin();
		
		AccountPage account=new AccountPage(driver);
		Assert.assertTrue(account.isAccountLoggedIn());

	}

}
