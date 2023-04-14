package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

	public WebDriver driver;

	public DriverUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForPresenceOfElement(int timeToWait, By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getTextFromTextBox(WebElement element, int timeToWait) {
		WebElement webElement = waitforElementToBeClickable(element, timeToWait);
		return webElement.getAttribute("value");
	}
	
	public String getTextFromTextBox(WebElement element) {
		WebElement webElement = waitforElementToBeClickable(element, 0);
		return webElement.getAttribute("value");
	}

	public void elementClick(WebElement element, int timeToWait) {
		WebElement webelement = waitforElementToBeClickable(element, timeToWait);
		webelement.click();
	}

	public void elementClick(WebElement element) {
		elementClick(element, 0);
	}

	public void typeTextOnElement(WebElement element, int timeToWait, String text) {
		WebElement webelement = waitforElementToBeClickable(element, timeToWait);
		webelement.clear();
		webelement.click();
		webelement.sendKeys(text);

	}

	public void typeTextOnElement(WebElement element, String text) {
		typeTextOnElement(element, 0, text);

	}
	
	public String getTextOfElement(WebElement element, int timeToWait) {
		WebElement webelement =waitforElementToBeVisible(element, timeToWait);
		return webelement.getText();
	}
	
	public String getTextOfElement(WebElement element) {
		return getTextOfElement(element, 0);
	}

	public WebElement waitforElementToBeClickable(WebElement element, int timeToWait) {
		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
			webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return webelement;

	}

	public WebElement waitforElementToBeVisible(WebElement element, int timeToWait) {
		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
			webelement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return webelement;

	}

	public void javascriptClick(WebElement element, int timeToWait) {
		WebElement webelement = waitforElementToBeClickable(element, timeToWait);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click()", webelement);
	}

	public void javascriptClick(WebElement element) {
		javascriptClick(element, 0);
	}

	public void javascriptType(WebElement element, int timeToWait, String text) {
		WebElement webelement = waitforElementToBeClickable(element, timeToWait);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + text + "'", webelement);

	}

	public void javascriptType(WebElement element, String text) {

		javascriptType(element, 0, text);
	}

	public void selectOptionInDropdown(WebElement element, int timeToWait, String option) {
		WebElement webelement = waitforElementToBeClickable(element, timeToWait);
		Select select = new Select(webelement);
		select.selectByValue(option);
	}

	public Alert waitForAlert(int timeToWait) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return alert;
	}

	public void acceptAlert(WebElement element, int timeToWait) {
		Alert alert = waitForAlert(timeToWait);
		alert.accept();
	}

	public void dismissAlert(WebElement element, int timeToWait) {
		Alert alert = waitForAlert(timeToWait);
		alert.dismiss();
	}

	public void mouseHoverAndClick(WebElement element, int timeToWait) {
		WebElement webelement = waitforElementToBeVisible(element, timeToWait);
		Actions actions = new Actions(driver);
		actions.moveToElement(webelement).click().build().perform();

	}

}
