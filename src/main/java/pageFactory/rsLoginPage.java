package pageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class rsLoginPage {

	public WebDriver driver = null;

	public rsLoginPage(WebDriver dr) { // ----Constructor----
		this.driver = dr;
		PageFactory.initElements(dr, this);
	}

	// ---Login Page ObjectFactory----------------

	@FindBy(id = "inputUsername")
	public WebElement userID;

	@FindBy(name = "inputPassword")
	public WebElement password;

	@FindBy(className = "signInBtn")
	public WebElement loginBttn;

}