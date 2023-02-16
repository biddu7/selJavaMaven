package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class rsLoginPage {
    
    public WebDriver driver = null;
	public rsLoginPage(WebDriver dr) {this.driver = dr;}  //----Constructor----	
	public WebElement get(By locator) {return driver.findElement(locator);}  //------Returns WebElement
	
	//------------- Login Page Element Locators ----------------
    public By userID = By.id("inputUsername");
    public By password = By.name("inputPassword");
    public By loginBttn = By.className("signInBtn");
    
}