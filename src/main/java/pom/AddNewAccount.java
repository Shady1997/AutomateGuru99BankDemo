package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAccount {

	WebDriver driver;

	public AddNewAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='New Account']")
	public WebElement addNewAccount;
	
	@FindBy(xpath = "//input[@name='cusid']")
	public WebElement customerID;

	@FindBy(xpath = "//select[@name='selaccount']")
	public WebElement accountType;
	
	@FindBy(xpath = "//input[@name='inideposit']")
	public WebElement initialDeposite;

	@FindBy(xpath = "//input[@name='button2']")
	public WebElement submitButton;

}
