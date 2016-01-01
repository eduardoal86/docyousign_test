package docyousign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailSendEmail {
	
	protected WebDriver driver;
	
	public GmailSendEmail(WebDriver driver) {
		this.driver = driver;
	} 
	
	By composeBtn = By.xpath("//div[contains(text(),'COMPOSE')]");
	//By composeBtn = By.xpath("//div[contains(text(),' Escrever')]");
	
	
	// Public method to find 'Compose' button and click
	public void clickCompose() {
		driver.findElement(composeBtn).click();
	}
	
	// Public method to fill a destination contact to send an email
	public void fillDestinationContactField() {
        driver.findElement(By.xpath("//textarea[@name='to']")).
        sendKeys("automation2355@gmail.com");
	}
	
	// Public method to fill subject
	public void fillSubjectEmailField() {
        driver.findElement(By.xpath("//input[@name='subjectbox']")).
        sendKeys("Automation Test");
	}
	
	// Public method for input a message 
	public void typeMessageEmail() {
		WebElement textArea = driver.findElement(By.xpath("//div[@class='Ar Au']//div"));
		textArea.click();
		textArea.clear();
		textArea.sendKeys("Hello DocYouSign!");
	}
	
	// Public method to click on 'Send' button
	public void clickOnSendBtn() {
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}

}
