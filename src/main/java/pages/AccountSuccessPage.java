package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverUtils;

public class AccountSuccessPage {

	
	public WebDriver driver;
	private DriverUtils driverUtils;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driverUtils = new DriverUtils(driver);
	}
	
	@FindBy(css="div[id='content'] h1")
	private WebElement successfulRegistrationMsg;
	
	
	By registrationSuccessfulMsg = By.cssSelector("div[id='content'] h1");
	
	
	
	public void waitForsuccessfulRegistrationMsg() {
		driverUtils.waitForPresenceOfElement(5, registrationSuccessfulMsg);

	}

	public String getsuccessfulRegistrationMsg() {
		return driverUtils.getTextOfElement(successfulRegistrationMsg);
		
		
	}
}
