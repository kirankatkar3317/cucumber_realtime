package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

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
		emailField.sendKeys(Email);
	}

	public void passwordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public AccountPage clickOnLoginSubmit() {
		loginSubmitButton.click();
		return new AccountPage(driver);
	}
	
	public String getInvalidCredentialMsg() {
		return invalidCredentialMsg.getText();
	}
}
