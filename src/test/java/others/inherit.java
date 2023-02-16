package others;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.rsLoginPage;
import pageFactory.rsLogoutPage;
import common1.util;

public class inherit extends util  {
	
	public WebDriver dr;
	@Test
	public void login() throws IOException, InterruptedException {
		
		dr = setDriver();
		browse("https://rahulshettyacademy.com/locatorspractice/");
		
		rsLoginPage login = new rsLoginPage(dr);
		
		login.userID.sendKeys("Joydeep Basu");
		login.password.sendKeys("rahulshettyacademy");
		login.loginBttn.click();
		
		Thread.sleep(2000);
		
		rsLogoutPage logout = new rsLogoutPage(dr);
		Assert.assertEquals(logout.msg.getAttribute("innerText"), "Hello Joydeep Basu,");
		logout.logoutBttn.click();
		
		close();
	}
	
	
}
