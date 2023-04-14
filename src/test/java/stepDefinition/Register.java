package stepDefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegistrationPage;
import utils.CommonUtils;
import webDriverFactory.DriverFactory;

public class Register {

	public WebDriver driver;

	private HomePage homePage;
	private RegistrationPage registrationPage;
	private AccountSuccessPage accountSuccessPage;

	@Given("user navigate to Register page")
	public void user_navigate_to_Register_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver).clickOnMyAccount();
	//	homePage.clickOnMyAccount();
		registrationPage = homePage.clickOnRegistration();
	}

	@When("user enters below field")
	public void user_enters_below_field(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registrationPage.mandatoryDetailsForRegistration(dataMap.get("firstName"), dataMap.get("lastName"),
				CommonUtils.getUniqueEmail(), dataMap.get("telephone"), CommonUtils.getUniquePassword());
		registrationPage.getConfirmPassword();
	}

	@When("user enters below duplicate field")
	public void user_enters_below_duplicate_field(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registrationPage.mandatoryDetailsForRegistration(dataMap.get("firstName"), dataMap.get("lastName"),
				dataMap.get("email"), dataMap.get("telephone"), dataMap.get("password"));
		registrationPage.getConfirmPassword();
	}

	@When("user dont enters any field")
	public void user_dont_enters_any_field() {
	//	registrationPage = new RegistrationPage(driver);
	}

	@Then("User account get successfully created")
	public void user_account_get_successfully_created() {
		accountSuccessPage.waitForsuccessfulRegistrationMsg();
		String accountCreationMessege = accountSuccessPage.getsuccessfulRegistrationMsg();
		Assert.assertEquals(accountCreationMessege, "Your Account Has Been Created!");

	}

	@Then("User should get a warning about duplicate email")
	public void user_should_get_a_warning_about_duplicate_email() {
	//	registrationPage = new RegistrationPage(driver);
		String duplicateEmailErroMessege = registrationPage.duplicateEmailWarning();
		Assert.assertEquals(duplicateEmailErroMessege, "Warning: E-Mail Address is already registered!");

	}

	@Then("User should get a warning messsge for every mandatory fields")
	public void user_should_get_a_warning_messsge_for_every_mandatory_fields() {

		String privacyerrormsg = registrationPage.privacyPolicyWarning();
		Assert.assertTrue(privacyerrormsg.contains("Warning: You must agree to the Privacy Policy!"));

		String firstNameErrorMsg = registrationPage.invalidFirstNameWarning();
		Assert.assertEquals(firstNameErrorMsg, "First Name must be between 1 and 32 characters!");

		String lastNameErrorMsg = registrationPage.invalidLastNameWarning();
		Assert.assertEquals(lastNameErrorMsg, "Last Name must be between 1 and 32 characters!");

		String emailErrorMsg = registrationPage.invalidEmailWarning();
		Assert.assertEquals(emailErrorMsg, "E-Mail Address does not appear to be valid!");

		String telephoneErrorMsg = registrationPage.invalidTelephoneWarning();
		Assert.assertEquals(telephoneErrorMsg, "Telephone must be between 3 and 32 characters!");

		String passwordErrorMsg = registrationPage.invalidPasswordWarning();
		Assert.assertEquals(passwordErrorMsg, "Password must be between 4 and 20 characters!");

	}

	@And("^user select privacy policy$")
	public void user_select_privacy_policy() {
		registrationPage.clickOnPrivacyPolicy();
	}

	@And("^user clicks on continue button$")
	public void user_clicks_on_continue_button() {
		accountSuccessPage = registrationPage.clickOnContinueButton();
	}

	@And("^user select yes for newsletter$")
	public void user_select_yes_for_newsletter() {
		registrationPage.selectYesForNewsletter();
	}

}
