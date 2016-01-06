package docyousign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchForAnEmailAndCheck {

	protected WebDriver driver;

	public SearchForAnEmailAndCheck(WebDriver driver) {
		this.driver = driver;
	}

	// these methods belongs to another class that will be called SearchEmail
	// this method can its name changed for look for a message
	// Public method for search an email
	public void clickOnSearchBox() {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.click();
		searchBox.sendKeys("hello docyousign");
		searchBox.sendKeys(Keys.RETURN);

	}

	// Public method to locate a message by subject
	public void listMessagesWithSubject() {
		WebElement firstMsg = driver.findElement(By.className("xS"));
		firstMsg.click();
	}

	// Public method to check Title`s message
	public WebElement getTitleMessage() {
		WebElement titleMsg = driver.findElement(By.className("hP"));

		return titleMsg;
	}

	// Public method to check destination`s message
	public WebElement getDestinationContact() {
		WebElement destination = driver.findElement(By.className("gD"));

		return destination;
	}

}
