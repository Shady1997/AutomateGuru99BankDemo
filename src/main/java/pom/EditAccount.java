package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccount {

	WebDriver driver;

	public EditAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Edit Account']")
	public WebElement chooseEditAccount;

	@FindBy(xpath = "//input[@name='accountno']")
	public WebElement accountNO;

	@FindBy(xpath = "//input[@name='AccSubmit']")
	public WebElement submitButton;

}
