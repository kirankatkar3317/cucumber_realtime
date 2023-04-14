package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverUtils;

public class LoginPage {

	public WebDriver driver;
	private DriverUtils driverUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driverUtils = new DriverUtils(driver);

	}

	@FindBy(css = "input[name='email']")
	private WebElement emailField;

	@FindBy(css = "#input-password")
	private WebElement passwordField;

	@FindBy(css = "input[value='Login']")
	private WebElement loginSubmitButton;
	
	@FindBy(css = ".alert.alert-danger.alert-dismissible")
	private WebElement invalidCredentialMsg;
	
	
	
	
	public void emailField(String Email) {
		driverUtils.typeTextOnElement(emailField, Email);
	}

	public void passwordField(String password) {
		driverUtils.typeTextOnElement(passwordField, password);
	}
	
	public AccountPage clickOnLoginSubmit() {
		driverUtils.elementClick(loginSubmitButton);
		return new AccountPage(driver);
	}
	
	public String getInvalidCredentialMsg() {
		return driverUtils.getTextOfElement(invalidCredentialMsg);
	}
}
