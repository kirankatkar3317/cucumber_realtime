package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;
import webDriverFactory.DriverFactory;

public class Search {

	public WebDriver driver;
	private HomePage homePage;
	private SearchPage searchPage;

	@Given("^user opens the application$")
	public void user_opens_the_application() {

		driver = DriverFactory.getDriver();
	}

	@When("user enter product {string} in search box field")
	public void user_enter_valid_product_something_in_search_box_field(String productName) {
		homePage = new HomePage(driver).enterProductNameOnSearchBox(productName);
	//	homePage.enterProductNameOnSearchBox(productName);
	}

	@When("user dont enter product in search box field")
	public void user_dont_enter_product_in_search_box_field() {
		homePage = new HomePage(driver);
	}

	@And("user click on search button")
	public void user_click_on_search_button() {
		searchPage = homePage.clickOnSearchButton();
	}

	@Then("user should get valid product in search results")
	public void user_should_get_valid_product_in_search_results() {
		boolean validProductname = searchPage.getValidProductInSearchResult();
		Assert.assertTrue(validProductname);

	}

	
	/*
	 * Failing this to capture sccreenshot
	 * expected result text are intentionally edited to fail the scenario to capture output
	 */
	@Then("user should get a messege about product in search results")
	public void user_should_get_a_messege_about_product_in_search_results() {

		String invalidProductNameError = searchPage.getInvalidProductMsg();
		Assert.assertEquals(invalidProductNameError, "There is no product that //////matches the search criteria.");
	}

}
