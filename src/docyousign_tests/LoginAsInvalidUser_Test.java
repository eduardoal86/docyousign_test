package docyousign_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import docyousign.GmailLoginPage;

public class LoginAsInvalidUser_Test {
	
private GmailLoginPage page;
	
	@Before
	public void openBrowser() {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.gmail.com");
		page = new GmailLoginPage(driver);
	}
	

	//Test for negative scenario
		@Test
		public void loginAsUserWithWrongCredentials() {
			page.loginAs("automation2355@gmail.com", "senhainvalida");
			page.checkMessageErrorIsVisible();
		}

}
