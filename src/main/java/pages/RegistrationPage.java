package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverUtils;

public class RegistrationPage {

	public WebDriver driver;
	private DriverUtils driverUtils;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driverUtils = new DriverUtils(driver);

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
		
		driverUtils.typeTextOnElement(firstNameField, firstName);
		driverUtils.typeTextOnElement(lastNameField, lastName);
		driverUtils.typeTextOnElement(emailField, email);
		driverUtils.typeTextOnElement(telephoneField, telephone);
		driverUtils.typeTextOnElement(passwordField, password);
		

	}

	public void getConfirmPassword() {
		String confirmPassword = driverUtils.getTextFromTextBox(passwordField);
		driverUtils.typeTextOnElement(confirmPasswordField, confirmPassword);
	}

	public void clickOnPrivacyPolicy() {
		driverUtils.elementClick(privacyPolicyRadioButton);
	}

	public AccountSuccessPage clickOnContinueButton() {
		driverUtils.elementClick(continueButton);
		return new AccountSuccessPage(driver);
	}

	public void selectYesForNewsletter() {
		driverUtils.elementClick(newsletterOptions);
	}

	public String duplicateEmailWarning() {
		return driverUtils.getTextOfElement(duplicateEmailWarning);
	}

	public String invalidEmailWarning() {
		return driverUtils.getTextOfElement(invalidEmailWarning);
	}

	public String invalidFirstNameWarning() {
		return driverUtils.getTextOfElement(invalidFirstNameWarning);
	}

	public String invalidLastNameWarning() {
		return driverUtils.getTextOfElement(invalidLastNameWarning);
	}

	public String invalidTelephoneWarning() {
		return driverUtils.getTextOfElement(invalidTelephoneWarning);
	}

	public String invalidPasswordWarning() {
		return driverUtils.getTextOfElement(invalidPasswordWarning);
	}

	public String privacyPolicyWarning() {
		return driverUtils.getTextOfElement(privacyPolicyWarning);
	}

}
