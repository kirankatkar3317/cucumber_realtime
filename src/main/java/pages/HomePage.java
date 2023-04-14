package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverUtils;

public class HomePage {

	public WebDriver driver;
	private DriverUtils driverUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driverUtils = new DriverUtils(driver);
	}

	@FindBy(css = ".fa.fa-user")
	private WebElement clickOnMyAccount;

	@FindBy(css = "li[class='dropdown open'] li:nth-child(2) a:nth-child(1)")
	private WebElement clickOnLogin;

	@FindBy(css = "li[class='dropdown open'] li:nth-child(1) a:nth-child(1)")
	private WebElement clickOnRegistration;

	@FindBy(css = "input[placeholder='Search']")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public HomePage clickOnMyAccount() {
		driverUtils.elementClick(clickOnMyAccount);
		return new HomePage(driver);
	}

	public LoginPage clickOnLogin() {
		driverUtils.elementClick(clickOnLogin);
		return new LoginPage(driver);
	}

	public RegistrationPage clickOnRegistration() {
		driverUtils.elementClick(clickOnRegistration);
		return new RegistrationPage(driver);
	}

	public HomePage enterProductNameOnSearchBox(String productName) {
		driverUtils.typeTextOnElement(searchBox, productName);
		return new HomePage(driver);
	}

	public SearchPage clickOnSearchButton() {
		driverUtils.javascriptClick(searchButton);
		return new SearchPage(driver);
		// searchButton.click();
	}

}
