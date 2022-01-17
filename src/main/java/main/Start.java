package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.LoginPage;

public class Start {

	WebDriver driver;
	FileInputStream readProperty;
	LoginPage login;

	@BeforeTest
	private void prepareClassProperties() throws IOException {
		readProperty = new FileInputStream(
				"C:\\Users\\G525585\\eclipse-workspace\\AutomateSwagLabsWebApplication\\src\\main\\java\\properties\\generalProperties.properties");
		Properties prop = new Properties();
		prop.load(readProperty);

		System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriver"));
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));

		driver = new FirefoxDriver();
		login = new LoginPage(driver);
	}

	@Test(priority = 1)
	private void startApplication() throws InterruptedException {

		// Mazimize current window
		driver.manage().window().maximize();

		// navigate to website
		driver.get("https://demo.guru99.com/V4/");

		// wait for 5 sec
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	private void login() throws InterruptedException {

		login.userName.sendKeys("mngr381022");

		login.userPassword.sendKeys("jazabAn");

		login.loginButton.click();

		// wait for 10 sec
		Thread.sleep(10000);

		Assert.assertEquals(driver.getPageSource().contains("mngr381022"), true);
	}

	@AfterTest
	private void closeApplication() {
		driver.quit();
	}

}
