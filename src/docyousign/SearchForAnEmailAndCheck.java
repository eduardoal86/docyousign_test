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
		// WebElement messageSub = driver.findElement(By.className("J-M
		// J-M-ayU"));
		// messageSub.click();
		// ArrayList<WebElement> messageSubject = new ArrayList<>();
		// messageSubject = (ArrayList<WebElement>)
		// driver.findElements(By.xpath("//*[@id=\":2y\"]"));
		// messageSubject.get(0).click();
		WebElement firstMsg = driver.findElement(By.className("y6"));
		// ("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div[5]"
		// + "/div[1]/div/table/tbody/tr[1]/td[6]/div/div/div[2]/span[1]/b"));
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
	
	// Public method to check destination`s message
	/*public WebElement getBeginingMessageText() {
		WebElement bodyMessage = driver.findElement(By.xpath("contains(text(),'Hello']"));
		return bodyMessage;
	}*/

}
