package common1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class general {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports report;
	
	public static String common_path = System.getProperty("user.dir") + "\\src\\main\\java\\common1\\";
	public static String report_path = System.getProperty("user.dir") + "\\ExtentReports\\";
	
	public static String propFileName = "param.properties";
	
	
	public static String readProp(String propertyName) throws IOException {
		
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(common_path + propFileName);
			prop.load(fis);
			fis.close();

			return prop.getProperty(propertyName);
	 }
	
	
	public static void writeProp(String propertyName, String propertyVal) throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream(common_path + propFileName));
		prop.setProperty(propertyName, propertyVal);
		//fis.close();
		
		FileOutputStream fos = new FileOutputStream(common_path + propFileName);
		prop.store(fos, null);
		
	}
	
	public static ExtentReports getExtentReport() {
		
		//Delete all existing files in specified directory including sub-directories
		//try {FileUtils.cleanDirectory(new File(report_path + "\\index.html"));
		//} catch (IOException e) {e.printStackTrace();}  
		
		reporter = new ExtentHtmlReporter(report_path + "\\index.html");
		
		reporter.config().setDocumentTitle("ExtentReports-Suite Run");
		reporter.config().setReportName("Selenium Java Web Automation");

		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Joydeep Basu");
		
		return report;
	}
	
	
	
	public static void elementSceenshot(WebElement wbl, String fileName) throws IOException {
		FileUtils.copyFile(wbl.getScreenshotAs(OutputType.FILE), new File(report_path + fileName + ".png"));	
	}
	
	public static String captureScreen(String MethodName, WebDriver driver) throws IOException {
		String fileName = MethodName + "_" + new SimpleDateFormat("dd.mm.yyyy-HH.mm.ss").format(new java.util.Date()) + ".png";
		File fl = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fl, new File(report_path + fileName));	
		
		return report_path + fileName;
	}
    
	
	
	
	
	public static int returnHttpStatusCode(String url) throws MalformedURLException, IOException {
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		return conn.getResponseCode();
	}
    
    
}


