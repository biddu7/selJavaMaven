package common1;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class util {
		
    public WebDriver driver = null;
    public WebElement wbl = null;
    
	public WebDriver setDriver() throws IOException {
		
		//String browser = System.getProperty("driver_browser");    //to get from System Property
		  String browser = general.readProp("driver_browser");    //to get from Property file 
		
		switch (browser) {
		
			case "firefox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\webdrivers\\geckodriver.exe");
				FirefoxOptions optFX = new FirefoxOptions();
				 
				if(general.readProp("browser_style").contains("headless")) {optFX.addArguments("headless");}
				
				driver = new FirefoxDriver(optFX); 
				break;
			
			case "edge":
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\webdrivers\\msedgedriver.exe");
				EdgeOptions optEG = new EdgeOptions();
				
				if(general.readProp("browser_style").contains("headless")) {optEG.addArguments("headless");}
				driver = new EdgeDriver(optEG);
				break;
			
			case "chrome":	
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\webdrivers\\chromedriver.exe");
				ChromeOptions optCR = new ChromeOptions();
				
				if(general.readProp("browser_style").contains("headless")) {optCR.addArguments("headless");}
				driver = new ChromeDriver(optCR); 
				break;
			}
		

	  //----------------------------------------------------Configure Driver Settings-----------------------------------
	    int timeout = Integer.parseInt(general.readProp("driver_timeout"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));  //Implicit wait using Duration object
		//driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);    //Implicit wait using TimeUnit object
		driver.manage().window().maximize();
		
	  //-----------------------------------------------------------------------------------------------------------------
		
		return driver;
	}
	
	
		public void browse(String url) {driver.get(url);}
	    public void close() { driver.close(); }
	    public void quit() { driver.quit(); }
	
	
	//--------------------------- Perform an element Method ------------------
    public void write(String method, String val) {
		switch(method) {
		    case "clear":     wbl.clear(); break;
		    case "click":     wbl.click(); break;
		    case "enter":     wbl.sendKeys(val); break;
		    case "submit":    wbl.submit(); break;
		    
		    default:          
		}
	}
	
	
	//--------------------------- Retrieve an element using locator ------------------
	public void getElement(String locator, String locVal) {
		
		wbl = null;
		switch(locator) {
		    case "id":        wbl = driver.findElement(By.id(locVal)); break;
		    case "name":      wbl = driver.findElement(By.name(locVal)); break;
		    case "class":     wbl = driver.findElement(By.className(locVal)); break;
		    case "tag":       wbl = driver.findElement(By.tagName(locVal)); break;
		    case "linkText":  wbl = driver.findElement(By.linkText(locVal)); break;
		    case "plinkTest": wbl = driver.findElement(By.partialLinkText(locVal)); break;
		    case "css":       wbl = driver.findElement(By.cssSelector(locVal)); break;
		    case "xpath":     wbl = driver.findElement(By.xpath(locVal)); break;
		    default:          wbl = null;
		}
	}
	
	
	//--------------------------- Retrieve an element property------------------
    public String read(String property) {
		String prop = "";
		
    	switch(property) {
		    case "text":     prop = wbl.getText(); break;
		    case "visible":  prop = String.valueOf(wbl.isDisplayed()); break;
		    case "enabled":  prop = String.valueOf(wbl.isEnabled()); break;
		    case "selected": prop = String.valueOf(wbl.isSelected()); break;
		    
		}
		return prop;
	}
    
}
