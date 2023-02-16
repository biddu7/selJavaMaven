package others;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReportTest {
   
	public static ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest extTest;
	
	@BeforeTest
	public void extRepConfig () {
		
		String path = System.getProperty("user.dir") + "\\ExtentReports\\index.html";
		reporter = new ExtentHtmlReporter(path);
		
		reporter.config().setDocumentTitle("ExtentReports-Suite Run");
		reporter.config().setReportName("Selenium Java Web Automation");

		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Joydeep Basu");
	}
	
	
	@Test
	public void Method1() {
		extTest = report.createTest(this.getClass().getSimpleName());
		
		String msg = "This is Extent Report Test method 1";
		System.out.println(msg);
		extTest.log(Status.INFO, "This is an infomation about the test");
		extTest.log(Status.ERROR, "This is an error message");
		extTest.log(Status.WARNING, "This is a warning message");
		extTest.log(Status.FATAL, "This is a fatal message");
		extTest.log(Status.PASS, "This is a pass message");
		
		report.flush();
	}
	
	@Parameters({"userid","password","url"})
	@Test(groups= {"smoke"})
	public void parameterTest(String user, String psw, String site) {
		
		System.out.println("This is Parameter Test"); 
		System.out.println("URL: [" + site + "]");
		System.out.println("User ID: [" + user + "]");
		System.out.println("Password: [" + psw + "]");
	}
	
}
