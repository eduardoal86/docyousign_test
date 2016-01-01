package docyousign_tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import docyousign.GmailLoginPage;
import docyousign.GmailSendEmail;
import docyousign.SearchForAnEmailAndCheck;

public class SendAnEmailAndCheck_Test {
	
	private GmailLoginPage page;
	private GmailSendEmail gsendMail;
	private SearchForAnEmailAndCheck searchMail;

	WebDriver driver;
	
	@Before
	public void openBrowser() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.gmail.com/");
		page = new GmailLoginPage(driver);
		gsendMail = new GmailSendEmail(driver);
		searchMail = new SearchForAnEmailAndCheck(driver);
	}

	@Test
	public void SendAMessageAndCheck() {
		//
		page.loginAs("automation2355@gmail.com", "automation");
		
		page.waitImplicit(3);
		gsendMail.clickCompose();
		page.waitImplicit(2);
		gsendMail.fillDestinationContactField();
		gsendMail.fillSubjectEmailField();
		gsendMail.typeMessageEmail();
		gsendMail.clickOnSendBtn();
		//Wait for see message sent
		page.waitImplicit(3);
		
		// Search for email sent
		searchMail.clickOnSearchBox();
		page.waitImplicit(5);
		searchMail.listMessagesWithSubject();
		
		assertEquals("Automation Test", searchMail.getTitleMessage().getText());
		assertEquals("Eduardo Lieuthier", searchMail.getDestinationContact().getText());
		
	}
	
}
