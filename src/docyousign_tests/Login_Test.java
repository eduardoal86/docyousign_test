package docyousign_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import docyousign.GmailLoginPage;

public class Login_Test extends WatchStepsClassConsole {

	private GmailLoginPage page;

	WebDriver driver;

	@Before
	public void openBrowser() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.gmail.com/");
		page = new GmailLoginPage(driver);
	}

	// Test for positive scenario
	@Test
	public void loginAsUserValid() {
		assertEquals(page.getTitle(), "Gmail");
		page.loginAs("automation2355@gmail.com", "automation");
	}

	// Test for negative scenario
	@Test
	public void loginAsUserWithWrongCredentials() {
		page.loginAs("automation2355@gmail.com", "senhainvalida");
		page.checkMessageErrorIsVisible();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.quit();
	}

}
