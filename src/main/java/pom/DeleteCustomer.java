package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {

	WebDriver driver;

	public DeleteCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Delete Customer']")
	public WebElement deleteCustomer;

	@FindBy(xpath = "//input[@name='cusid']")
	public WebElement customerID;

	@FindBy(xpath = "//input[@name='AccSubmit']")
	public WebElement submitCustomerID;

}
