package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.FirefoxOptions;
import org.openqa.selenium.chrome.EdgeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	protected WebDriver driver;
	String URL = "https://www.meesho.com/";
	
	@Parameters("browser")
	@BeforeClass
	public void suiteSetUp(@Optional("Chrome") String browser) {
		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			
		}else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions ();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
			
		}else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options=new EdgeOptions();
			options.setHeadless(true);
			driver=new EdgeDriver(options);
			
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
	
	
	@AfterClass
	public void suiteteardown() {
		driver.quit();
	}
}
