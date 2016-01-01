package docyousign_tests;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class WatchStepsClassConsole {

	static File file;
	static BufferedWriter bufferedW;
	
	
	//This part will take the start time and create a file to save results 
	@BeforeClass
	public static void setUp() throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date();
		file = new File("test_results.htm");
		bufferedW = new BufferedWriter(new FileWriter(file, true));
		bufferedW.write("<html><body>");
		bufferedW.write("<h1>Test Case Status - " + dateFormat.format(date) + "</h1>");

	}

	//Always the method tearDown() is called, at this point will close html report with tags.
	//Finally, will be displayed the results of test scenarios
	@AfterClass
	public static void tearDown() throws IOException {
		bufferedW.write("</body></html>");
		bufferedW.close();
		Desktop.getDesktop().browse(file.toURI());

	}

	@Rule
	public TestRule watchStep = new TestWatcher() {

		@Override
		public Statement apply(Statement base, Description description) {
			return super.apply(base, description);
		}

		//When a test has status: passed. It will be set on report a 'Success' string
		@Override
		protected void succeeded(Description description) {
			try {
				bufferedW.write(description.getDisplayName() + " " + "success!");
				bufferedW.write("<br/>"); 
				}
				catch (Exception e1) {
				System.out.println(e1.getMessage());
				}
		}

		//When a test has status: failed. It will be set on report a 'Failed' string
		@Override
		protected void failed(Throwable e, Description description) {
			try {
				bufferedW.write(description.getDisplayName() + " " + e.getClass().getSimpleName());
				bufferedW.write("<br/>"); 
				}
				catch (Exception e2) {
				System.out.println(e2.getMessage());
				}
		}
	};

}
