package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.AddNewAccount;
import pom.AddNewCustomer;
import pom.DeleteCustomer;
import pom.EditCustomer;
import pom.LoginPage;
import utility.Utility;

public class Start {

	WebDriver driver;
	FileInputStream readProperty;
	JavascriptExecutor js;
	LoginPage login;
	AddNewCustomer addNewCustomer;
	EditCustomer editCustomer;
	DeleteCustomer deleteCustomer;
	AddNewAccount addNewAccount;
	String CUSTOMERID = null;
	String ACCOUNTID =null;

	@BeforeTest
	private void prepareClassProperties() throws IOException {
		readProperty = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\properties\\generalProperties.properties");
		Properties prop = new Properties();
		prop.load(readProperty);

		System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriver"));
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));

		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		login = new LoginPage(driver);
		addNewCustomer = new AddNewCustomer(driver);
		editCustomer = new EditCustomer(driver);
		deleteCustomer = new DeleteCustomer(driver);
		addNewAccount = new AddNewAccount(driver);
	}

	@Test(priority = 1)
	private void startApplication() throws InterruptedException {
		// Mazimize current window
		driver.manage().window().maximize();
		// navigate to website
		driver.get("https://demo.guru99.com/V4/");
		// take screenshot to login page
		Utility.captureScreenshot(driver, "LoginPage");
		// wait for 5 sec
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	private void login() throws InterruptedException {
		// add username
		login.userName.sendKeys("mngr381022");
		// add password
		login.userPassword.sendKeys("jazabAn");
		// click login button
		login.loginButton.click();
		// take screenshot to verify login
		Utility.captureScreenshot(driver, "HomePage");
		// wait for 10 sec
		Thread.sleep(5000);
		// verify login successfully
		Assert.assertEquals(driver.getPageSource().contains("mngr381022"), true);
	}

	@Test(priority = 3)
	private void addCustomer() throws InterruptedException {
		// add New Customer
		addNewCustomer.addNewCUstomer.click();
		// wait for 5 sec
		Thread.sleep(10000);
		// verify page
		Assert.assertEquals(driver.getPageSource().contains("Add New Customer"), true);
		// add customer name
		addNewCustomer.customerName.sendKeys("mariam ahmed");
		// choose gender
		addNewCustomer.gender.click();
		// add birth date
		addNewCustomer.gender.sendKeys("01011997");
		Thread.sleep(10000);
		// scroll down
		js.executeScript("window.scrollBy(0,300)", "");
		// add customer address
		addNewCustomer.addAddress.sendKeys("13 mstafa kamel street");
		// add customer city
		addNewCustomer.addCity.sendKeys("Sharkia");
		// add customer state
		addNewCustomer.addState.sendKeys("Abu Kabir");
		// add customer postal code
		addNewCustomer.addPINCode.sendKeys("446717");
		// add mobile number
		addNewCustomer.addMobileNumber.sendKeys("01203199419");
		// add customer email address
		addNewCustomer.addEmail.sendKeys("shady1221@yahoo.com");
		// add customer password
		addNewCustomer.addPassword.sendKeys("P@ssw0rd");
		// take screenshot to starting add customer page
		Utility.captureScreenshot(driver, "addCustomer");
		// submit form
		addNewCustomer.submitForm.click();
		Thread.sleep(10000);
		// take screenshot to confirm submitting form
		Utility.captureScreenshot(driver, "submit");
		// save customer id to be used later
		CUSTOMERID = driver.getCurrentUrl().toString().substring(driver.getCurrentUrl().toString().indexOf("?") + 5);
		// verify page
		Assert.assertEquals(driver.getPageSource().contains("Customer Registered Successfully!!!"), true);
		// scroll down
		js.executeScript("window.scrollBy(0,300)", "");
		// return to home pgae
		addNewCustomer.continueButton.click();
		Thread.sleep(5000);
	}

	@Test(priority = 4)
	private void editCustomerData() throws InterruptedException {
		// click edit customer
		editCustomer.editCustomer.click();
		// take screenshot of edit page
		Utility.captureScreenshot(driver, "editPage");
		// wait to page to load
		Thread.sleep(3000);
		// verify page opened correctly
		Assert.assertEquals(driver.getPageSource().contains("Edit Customer Form"), true);
		// add customer ID to search with
		editCustomer.customerID.sendKeys(CUSTOMERID);
		// click submit
		editCustomer.submitCustomerID.click();
		// wait to page to load
		Thread.sleep(3000);
		// verify page opened correctly
		Assert.assertEquals(driver.getPageSource().contains("Edit Customer"), true);
		// scroll down
		js.executeScript("window.scrollBy(0,300)", "");
		// Keys.chord to pass multiple strings
		String n = Keys.chord(Keys.CONTROL, "A");
		// overwrite customer email
		editCustomer.updateCustomerEmail.sendKeys(n, "test1333@yahoo.com");
		// submit updated data
		editCustomer.submitUpdatedData.click();
		// take screenshot to confirmm updating page
		Utility.captureScreenshot(driver, "confirmEditPage");
		// wait to page to load
		Thread.sleep(3000);
		// verify updating customer data
		Assert.assertEquals(
				driver.switchTo().alert().getText().toString().contains("No Changes made to Customer records"), true);
		// accept alert
		driver.switchTo().alert().accept();
		// return to home page
		editCustomer.returnToHomePage.click();
		// wait to page to load
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	private void deleteCustomer() throws InterruptedException {
		// choose delete customer
		deleteCustomer.deleteCustomer.click();
		// wait to page to load
		Thread.sleep(3000);
		// verify page opened correctly
		Assert.assertEquals(driver.getPageSource().contains("Delete Customer Form"), true);
		// take screenshot of delete page
		Utility.captureScreenshot(driver, "deleteCustomerPage");
		// send customer ID
		deleteCustomer.customerID.sendKeys(CUSTOMERID);
		// submit form
		deleteCustomer.submitCustomerID.click();
		// confirm deleting in alert message
		driver.switchTo().alert().accept();
	}

	@Test(priority = 5)
	private void addNewAccount() throws InterruptedException {
		// choose add account
		addNewAccount.addNewAccount.click();
		// wait to page to load
		Thread.sleep(3000);
		// verify page opened correctly
		Assert.assertEquals(driver.getPageSource().contains("Add new account form"), true);
		// take screenshot of add account page
		Utility.captureScreenshot(driver, "addNewAccountPage");
		// send customer ID
		addNewAccount.customerID.sendKeys(CUSTOMERID);
		// select account type
		Select chooseAccountType = new Select(addNewAccount.accountType);
		chooseAccountType.selectByIndex(1);
		// add initial deposit
		addNewAccount.initialDeposite.sendKeys("1000");
		// submit form
		addNewAccount.submitButton.click();
		// verify page opened correctly
		Assert.assertEquals(driver.getPageSource().contains("Account Generated Successfully!!!"), true);
		// take screenshot to confirm add new account
		Utility.captureScreenshot(driver, "confirmAddNewAccount");
		//store AccountID
		ACCOUNTID=driver.getCurrentUrl().toString().substring(driver.getCurrentUrl().toString().indexOf("?") + 5);
	}

	@AfterTest
	private void closeApplication() {
		driver.quit();
	}

}
