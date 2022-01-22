package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {

	WebDriver driver;

	public EditCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Edit Customer']")
	public WebElement editCustomer;

	@FindBy(xpath = "//input[@name='cusid']")
	public WebElement customerID;
	
	@FindBy(xpath = "//input[@name='AccSubmit']")
	public WebElement submitCustomerID;
	
	@FindBy(xpath = "//input[@name='emailid']")
	public WebElement updateCustomerEmail;
	
	@FindBy(xpath = "//input[@name='sub']")
	public WebElement submitUpdatedData;
	
	@FindBy(xpath = "//a[normalize-space()='Home']")
	public WebElement returnToHomePage;

}
