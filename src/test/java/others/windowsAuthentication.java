package others;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common1.util;

public class windowsAuthentication extends util {

	public WebDriver dr;
	
	@Test
	public void testWinAuth() throws IOException, InterruptedException {
		dr = setDriver();
		dr.manage().deleteAllCookies();
		dr.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		Thread.sleep(2000);
		String msg = dr.findElement(By.cssSelector("div[class='example'] p")).getText();
		System.out.println( msg );
		dr.close();
	}
	
}
