package common1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class listener implements ITestListener {
	
	ExtentReports html = general.getExtentReport();
	ExtentTest extTest;
	ThreadLocal<ExtentTest> threads = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		//ITestListener.super.onTestStart(result);
		extTest = html.createTest(result.getMethod().getMethodName());
		threads.set(extTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//ITestListener.super.onTestSuccess(result);
		threads.get().log(Status.PASS, "Test [" + result.getMethod().getMethodName() + "] is passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//ITestListener.super.onTestFailure(result);
		
		threads.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		
		try {driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("dr").get(result.getInstance());} 
		catch (Exception e) {e.printStackTrace();}
		
		try {threads.get().addScreenCaptureFromPath(general.captureScreen(result.getMethod().getMethodName(), driver));
		     driver.close();
		     } 
		catch (IOException e) {e.printStackTrace();}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		//ITestListener.super.onFinish(context);
		html.flush();
	}

}
