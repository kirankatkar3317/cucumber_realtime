package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
		clickOnMyAccount.click();
		return new HomePage(driver);
	}
	
	public LoginPage clickOnLogin() {
		clickOnLogin.click();
		return new LoginPage(driver);
	}
	
	public RegistrationPage clickOnRegistration() {
		clickOnRegistration.click();
		return new RegistrationPage(driver);
	}
	
	public HomePage enterProductNameOnSearchBox(String productName) {
		searchBox.sendKeys(productName);
		return new HomePage(driver);
	}
	
	public SearchPage clickOnSearchButton() {
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", searchButton);
		return new SearchPage(driver);
	//	searchButton.click();
	}


	
	
}
