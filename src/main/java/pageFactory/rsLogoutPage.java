package pageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class rsLogoutPage {

	public WebDriver driver = null;

	public rsLogoutPage(WebDriver dr) { // ----Constructor----
		this.driver = dr;
		PageFactory.initElements(dr, this);
	}

	// ---Logout Page ObjectFactory----------------
	@FindBy(css = "div.login-container > h2")
	public WebElement msg;

	@FindBy(xpath = "//button[text()='Log Out']")
	public WebElement logoutBttn;

}
