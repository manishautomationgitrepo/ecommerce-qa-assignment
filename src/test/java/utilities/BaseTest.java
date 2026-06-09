package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	public WebDriver driver; 
	public Properties prop;
    
	@BeforeMethod
	public void setup() throws IOException
	{
		
		//loading config.properties file.
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\utilities\\config.properties");
		prop=new Properties();
		prop.load(file);
		
		
		ChromeOptions options = new ChromeOptions();

        // Disable save password Pop-up
		Map<String, Object> prefs = new HashMap<>();

		// Disable password Pop-up
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		// IMPORTANT: Disable address Auto-fill Pop-up
		prefs.put("autofill.profile_enabled", false);

		options.setExperimentalOption("prefs", prefs);

		
		switch("Chrome")
		{
		case "Chrome":
			
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("webURL"));
			break;
			
		case "Firefox":
			
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("webURL"));
			break;
			
		case "Edge":	
			
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("webURL"));
			break;
			
		case "Ie":	
			
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("webURL"));
			break;
	
		default:
			System.out.println("Invalid Web Browser Calling");
		}
	}
    
	@AfterMethod
	public void tearDown()
	{
		//close browser
		//driver.quit();
	}
}
