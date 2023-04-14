package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	public WebDriver driver;
	
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css="h2:nth-child(1)")
	private WebElement successfulLoginMsg;
	
	
//	String accountCreationMessege = driver.findElement(By.cssSelector("div[id='content'] h1")).getText();

	
	public String getsuccessfulLoginMsg() {
		return successfulLoginMsg.getText();
		
	}

	
}
