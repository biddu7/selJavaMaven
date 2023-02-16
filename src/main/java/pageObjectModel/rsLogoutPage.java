package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class rsLogoutPage {

    public WebDriver driver = null;
	public rsLogoutPage(WebDriver dr) {this.driver = dr;}  //----Constructor----	
	public WebElement get(By locator) {return driver.findElement(locator);}  //------Returns WebElement
	
	 //------------- Logout Page Element Locators ---------------
    public By msg = By.cssSelector("div.login-container > h2");
    public By logoutBttn = By.xpath("//button[text()='Log Out']");
	
}
