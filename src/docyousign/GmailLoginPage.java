package docyousign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailLoginPage {

	protected WebDriver driver;

	public GmailLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Ids for interact with elements at home page
	By usernameLocator = By.id("Email");
	By passwordLocator = By.id("Passwd");
	By btnNextUsername = By.id("next");
	By btnSignIn = By.id("signIn");

	// Public method to fill username field
	public GmailLoginPage typeUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);

		return this;
	}

	// Public method for fill password field
	public GmailLoginPage typePassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);

		return this;
	}
	
	// Public method for login as user, filling fields and click login button
	public GmailLoginPage loginAs(String username, String password) {
		typeUsername(username);
		clickNextForUsername();
		//included wait time for better script demonstration
		waitImplicit(2);
		typePassword(password);
		return clickLoginBtn();
		
		
	}

	// Public method to click 'next' after filled username field
	public GmailLoginPage clickNextForUsername() {
		waitImplicit(2);
		driver.findElement(btnNextUsername).click();

		return this;
	}

	// Public method to click 'Fazer login' fields filled
	public GmailLoginPage clickLoginBtn() {
		waitImplicit(2);
		driver.findElement(btnSignIn).click();

		return this;
	}
	
	
	// Public method to return title's page
	public String getTitle() {
		return driver.getTitle();
	}
	
	// Public method to check if a message id error is visible
	public Boolean checkMessageErrorIsVisible() {
		WebElement errorId = driver.findElement(By.id("errormsg_0_Passwd"));
		if (errorId.isDisplayed()) {
			return true;
		}
		return false;
	}

	// Public method 
	public void waitImplicit(Integer time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

}
