package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_check_invironment {
	WebDriver driver;
//pre-condition
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
	}
//Testcase
	@Test
	public void TC_01_ValidateCurrentUrl() {
		// Login Page Url matching
		String loginPageUrl = driver.getCurrentUrl();
		System.out.println(loginPageUrl);
		Assert.assertEquals(loginPageUrl, "http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_02_ValidatePageTitle() {
		// Login Page title
		String loginPageTitle = driver.getTitle();
		System.out.println(loginPageTitle);
		Assert.assertEquals(loginPageTitle, "Guru99 Bank Home Page");
	}

	@Test
	public void TC_03_LoginFormDisplayed() {
		// Login form displayed
		boolean loginformStatus = driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed();
		System.out.println("login form status = " + loginformStatus);
		Assert.assertTrue(loginformStatus);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}