package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {

	WebDriver driver;

	public AddNewCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='New Customer']")
	public WebElement addNewCUstomer;

	@FindBy(xpath = "//input[@name='name']")
	public WebElement customerName;

	@FindBy(xpath = "//input[@value='f']")
	public WebElement gender;

	@FindBy(xpath = "//input[@id='dob']")
	public WebElement selectDataPicker;

	@FindBy(xpath = "//input[@id='dob']")
	public WebElement addBirthDate;

	@FindBy(xpath = "//textarea[@name='addr']")
	public WebElement addAddress;

	@FindBy(xpath = "//input[@name='city']")
	public WebElement addCity;

	@FindBy(xpath = "//input[@name='state']")
	public WebElement addState;

	@FindBy(xpath = "//input[@name='pinno']")
	public WebElement addPINCode;

	@FindBy(xpath = "//input[@name='telephoneno']")
	public WebElement addMobileNumber;
	
	@FindBy(xpath = "//input[@name='emailid']")
	public WebElement addEmail;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement addPassword;

	@FindBy(xpath = "//input[@name='sub']")
	public WebElement submitForm;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	public WebElement continueButton;
}
