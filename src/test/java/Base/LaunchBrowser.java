package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	protected WebDriver driver;
	String URL = "https://www.meesho.com/";
	
	private static final String BROWSER = System.getProperty("browser", "Chrome");
	
	@BeforeSuite
	public void suiteSetUp() {
		if (BROWSER.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			
		}else if (BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if (BROWSER.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else {
			throw new RuntimeException("Browser Type Unsupported");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@BeforeMethod
	public void launchWebsite() {
		driver.get(URL);
	}
	
	
	@AfterSuite
	public void suiteteardown() {
		driver.quit();
	}
}
