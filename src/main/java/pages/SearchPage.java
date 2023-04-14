package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	public WebDriver driver;
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(css="div[class='caption'] h4 a")
	private WebElement validsearchedProduct;
	
	@FindBy(css="body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > p:nth-child(7)")
	private WebElement invalidsearchedProduct;

	
	public boolean getValidProductInSearchResult() {
		return validsearchedProduct.isDisplayed();
		
	}
	
	//p[contains(text(),'There is no product that matches the search criter')]
	
	public String getInvalidProductMsg() {
		return invalidsearchedProduct.getText();
		
		
	}

}
