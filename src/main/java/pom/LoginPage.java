package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='uid']")
	public WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement userPassword;

	@FindBy(xpath = "//input[@name='btnLogin']")
	public WebElement loginButton;
}
