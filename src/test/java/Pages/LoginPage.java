package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="sc-eDvSVe.gUjMRV.hover.hover'")
	WebElement Profile;

	@FindBy(className="sc-eDvSVe.fpkPeP")
	@CacheLookup
	WebElement SignUp;
	
	@FindBy(className="sc-eDvSVe.dDIvtJ")
	WebElement Country;
	
	@FindBy(xpath="//div[@class='Input__InputContainer-sc-1goybxj-0.gnonfD']/input[@type='tel']")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//span[@class='sc-eDvSVe.fpkPeP'][text()='Continue']")
	WebElement Cntnbtn;
	
	@FindBy(xpath="//div[@class='OtpVerifystyled__StyledOTPInputComponent-sc-iajphr-1 ihvJOs']/input[@type='tel']")
	List<WebElement> Otp;
	
	
	public List<WebElement> getOtp() {
		return Otp;
	}
	
	public WebElement getProfile() {
		return Profile;
	}
	
	public WebElement getSignUp() {
		return SignUp;
	}
	
	public WebElement getCountry() {
		return Country;
	}
	
	public WebElement getPhoneNumber() {
		return PhoneNumber;
	}
	
	public WebElement getContinuebtn() {
		return Cntnbtn;
	}
	
	public void hoverOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void btnclick(WebElement element) {
		element.click();
	}
	
	public void setPhoneNumber(WebElement element, String text) {
		element.sendKeys(text);
	}

}
