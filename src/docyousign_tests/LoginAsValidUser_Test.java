package docyousign_tests;

import static org.junit.Assert.*;

import org.apache.bcel.classfile.Utility;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import docyousign.GmailLoginPage;
import docyousign.GmailSendEmail;
import docyousign.SearchForAnEmailAndCheck;

public class LoginAsValidUser_Test {
	
private GmailLoginPage page;
private GmailSendEmail gsendMail;
private SearchForAnEmailAndCheck searchMail;

WebDriver driver;

/*ExtentReports report;
ExtentTest logger;*/
	
	@Before
	public void openBrowser() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.gmail.com/");
		page = new GmailLoginPage(driver);
		gsendMail = new GmailSendEmail(driver);
		searchMail = new SearchForAnEmailAndCheck(driver);
	}

	//Test for positive scenario
	@Test
	public void loginAsUserValid() {
		/*report = new ExtentReports("//Users//edulieuthier//development"
				+ "//DocYouSignTest//report//report.html");
		logger = report.startTest("Teste1");*/
		
		assertEquals(page.getTitle(), "Gmail");
		page.loginAs("automation2355@gmail.com", "automation");
		//assertEquals(page.getTitle(), "BOL - Brasil Online");
		//page.loginAs("eduardoal86@bol.com.br", "automation123");
		
		
		page.waitImplicit(2);
		gsendMail.clickCompose();
		page.waitImplicit(2);
		gsendMail.fillDestinationContactField();
		gsendMail.fillSubjectEmailField();
		gsendMail.typeMessageEmail();
		gsendMail.clickOnSendBtn();
		//Wait for see message sent
		page.waitImplicit(2);
		// Search for email sent
		searchMail.clickOnSearchBox();
		page.waitImplicit(5);
		searchMail.listMessagesWithSubject();
		
		assertEquals("Automation Test", searchMail.getTitleMessage().getText());
		assertEquals("Eduardo Lieuthier", searchMail.getDestinationContact().getText());
		//assertEquals("Hello", searchMail.getBeginingMessageText().getText());
		}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			
		}
		/*report.endTest(logger);
		report.flush();*/
		driver.quit();
	}
	
	
}
