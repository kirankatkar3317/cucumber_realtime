package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverUtils;

public class AccountPage {

	public WebDriver driver;
	private DriverUtils driverUtils;
	
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driverUtils = new DriverUtils(driver);
	}
	

	@FindBy(css="h2:nth-child(1)")
	private WebElement successfulLoginMsg;
	
	
//	String accountCreationMessege = driver.findElement(By.cssSelector("div[id='content'] h1")).getText();

	
	public String getsuccessfulLoginMsg() {
		return driverUtils.getTextOfElement(successfulLoginMsg);
		
	}

	
}
