package Suite;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common1.util;
import pageObjectModel.rsLoginPage;
import pageObjectModel.rsLogoutPage;

public class pomTest extends util {

	public static Logger log = LogManager.getLogger(pomTest.class.getName());
	
	public WebDriver dr;
	@BeforeTest public void openUrl() throws IOException {
		//dr = setDriver();
		}
	@AfterTest public void closeBrowser() {
		//close();
		quit();
	}	
	
	
	@Test(dataProvider="getDataExcel", dataProviderClass=common1.testdata.class)
	public void PageObjectModel(String url, String user, String psw) throws InterruptedException, IOException {
			
		dr = setDriver(); dr.get(url);
		
		log.info("Navigated to url [" + url + "]");
		
		//--------- Login Page-------------------
		rsLoginPage login = new rsLoginPage(dr);   //--------- ObjectRepo Class--------
		
		login.get(login.userID).sendKeys(user);
		login.get(login.password).sendKeys(psw);
		login.get(login.loginBttn).click();
		
		Thread.sleep(1000);
		log.info("logged in successfully with user [" + user + "]");
		
		//--------- Logout Page-------------------
		rsLogoutPage logout = new rsLogoutPage(dr); //--------- ObjectRepo Class--------
		
		Assert.assertEquals(logout.get(logout.msg).getAttribute("innerText"), "Hello "+ user +",");
		logout.get(logout.logoutBttn).click();
		
		log.info("logged out successfully");
		
		close();
	}
	
}
