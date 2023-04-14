package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
import webDriverFactory.DriverFactory;

public class Login {

	public WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private AccountPage accountPage;

	@Given("user navigate to login page")
	public void user_navigate_to_login_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver).clickOnMyAccount();;
		//homePage.clickOnMyAccount();
		loginPage = homePage.clickOnLogin();
	}
//	
//	@When("user has entered valid email address {string}")
//	public void user_has_entered_valid_email_address_something(String validEmail) {
//		loginPage.emailField(validEmail);
//	}
//
//	@And("user has entered valid password {string}")
//	public void user_has_entered_valid_password_something(String validPassword) {
//		loginPage.passwordField(validPassword);
//	}
	@When("^user has entered valid email address (.+)$")
	public void user_has_entered_valid_email_address_something(String validEmail) {
		loginPage.emailField(validEmail);
	}

	@When("user has entered invalid email address")
	public void user_has_entered_invalid_email_address_something() {
		loginPage.emailField(CommonUtils.getUniqueEmail());
	}

	@When("user dont enter any email in email field")
	public void user_dont_enter_any_email_in_email_field() {
	}

	@Then("user should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		String actualText = accountPage.getsuccessfulLoginMsg();
		Assert.assertEquals(actualText, "My Account");
	}

	@Then("user should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		String invalidCredentialsMessage = loginPage.getInvalidCredentialMsg();
		Assert.assertEquals(invalidCredentialsMessage, "Warning: No match for E-Mail Address and/or Password.");

	}

	@And("^user has entered valid password (.+)$")
	public void user_has_entered_valid_password_something(String validPassword) {
		loginPage.passwordField(validPassword);
	}

	@And("user click on login button")
	public void user_click_on_login_button() {
		accountPage = loginPage.clickOnLoginSubmit();
	}

	@And("user has entered invalid password")
	public void user_has_entered_invalid_password_something() {
		loginPage.passwordField(CommonUtils.getUniquePassword());
	}

	@And("user dont enter any password in password field")
	public void user_dont_enter_any_password_in_password_field() {

	}

}
