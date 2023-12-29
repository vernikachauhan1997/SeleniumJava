package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Base.LaunchBrowser;
import Pages.LoginPage;

public class MeeshoLoginPage extends LaunchBrowser {

	LoginPage loginpg;
	
	@Test()
	public void SignUp() {
		loginpg = new LoginPage(driver);
		try {
				if(loginpg.getProfile().isDisplayed()) {
					loginpg.hoverOnElement(loginpg.getProfile());
					loginpg.btnclick(loginpg.getSignUp());
					Thread.sleep(2000);
					if(loginpg.getCountry().isDisplayed()) {
						loginpg.getCountry().getAttribute("innertext").equals("IN +91");
						loginpg.setPhoneNumber(loginpg.getPhoneNumber(), "");
						loginpg.btnclick(loginpg.getContinuebtn());
						
						
						}
			}
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
}
