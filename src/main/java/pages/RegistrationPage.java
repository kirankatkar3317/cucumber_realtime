package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	public WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[value='1'][name='agree']")
	private WebElement privacyPolicyRadioButton;

	@FindBy(css = "input[id='input-firstname']")
	private WebElement firstNameField;

	@FindBy(css = "input[id='input-lastname']")
	private WebElement lastNameField;

	@FindBy(css = "input[id='input-email']")
	private WebElement emailField;

	@FindBy(css = "input[id='input-telephone']")
	private WebElement telephoneField;

	@FindBy(css = "input[id='input-password']")
	private WebElement passwordField;

	@FindBy(css = "input[id='input-confirm']")
	private WebElement confirmPasswordField;

	@FindBy(css = "input[value='Continue']")
	private WebElement continueButton;

	@FindBy(css = "input[value='1'][name='newsletter']")
	private WebElement newsletterOptions;

	@FindBy(xpath = "//input[@name='email']/following-sibling::div")
	private WebElement invalidEmailWarning;

	@FindBy(xpath = "//input[@name='firstname']/following-sibling::div")
	private WebElement invalidFirstNameWarning;

	@FindBy(xpath = "//input[@name='lastname']/following-sibling::div")
	private WebElement invalidLastNameWarning;

	@FindBy(xpath = "//input[@name='telephone']/following-sibling::div")
	private WebElement invalidTelephoneWarning;

	@FindBy(xpath = "//input[@name='password']/following-sibling::div")
	private WebElement invalidPasswordWarning;

	@FindBy(css = ".alert.alert-danger.alert-dismissible")
	private WebElement privacyPolicyWarning;

	@FindBy(css = ".alert.alert-danger.alert-dismissible")
	private WebElement duplicateEmailWarning;

	public void mandatoryDetailsForRegistration(String firstName, String lastName, String email, String telephone,
			String password) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		telephoneField.sendKeys(telephone);
		passwordField.sendKeys(password);

	}

	public void getConfirmPassword() {
		String confirmPassword = passwordField.getAttribute("value");
		confirmPasswordField.sendKeys(confirmPassword);
	}

	public void clickOnPrivacyPolicy() {
		privacyPolicyRadioButton.click();
	}

	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public void selectYesForNewsletter() {
		newsletterOptions.click();
	}

	public String duplicateEmailWarning() {
		return duplicateEmailWarning.getText();
	}

	public String invalidEmailWarning() {
		return invalidEmailWarning.getText();
	}

	public String invalidFirstNameWarning() {
		return invalidFirstNameWarning.getText();
	}

	public String invalidLastNameWarning() {
		return invalidLastNameWarning.getText();
	}

	public String invalidTelephoneWarning() {
		return invalidTelephoneWarning.getText();
	}

	public String invalidPasswordWarning() {
		return invalidPasswordWarning.getText();
	}

	public String privacyPolicyWarning() {
		return privacyPolicyWarning.getText();
	}

}
