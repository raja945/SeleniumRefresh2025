package dd_Framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDF02_DataProvider {
	WebDriver chdriver;

//	String[][] loginData = { { "student", "Password123" },
//			{ "student_invalid", "Password123" },
//			{ "student", "Password123_invalid" },
//			{ "un_invalid", "pw_invalid" } };

	@DataProvider(name="loginDataprovider")
	private String[][] loginDaloginDatataprovider() {
		return new String [][] {{ "student", "Password123" },
			{ "student_invalid", "Password123" },
			{ "student", "Password123_invalid" },
			{ "un_invalid", "pw_invalid" }};
	}

	@Test(dataProvider = "loginDataprovider")
	public void practiceSiteLogin(String unameValue, String pwordValue) {
		ChromeOptions choptions = new ChromeOptions();
		choptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		chdriver = new ChromeDriver(choptions);
		chdriver.manage().window().maximize();
		System.out.println(choptions.getBrowserName() + "browser launched successfully");
		chdriver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		// wait for the page to load
		Wait<WebDriver> wait = new FluentWait<WebDriver>(chdriver).withTimeout(Duration.ofSeconds(30)) // Maximum time
				.pollingEvery(Duration.ofSeconds(5)) // Check every 5 seconds
				.ignoring(NoSuchElementException.class);
		WebElement username = chdriver.findElement(By.id("username"));
		wait.until(driver -> username);
		// Entering username
		username.sendKeys(unameValue);
		// Entering password
		WebElement password = chdriver.findElement(By.name("password"));
		password.sendKeys(pwordValue);
		// Clicking on Login Btn
		WebElement loginBtn = chdriver.findElement(By.id("submit"));
		loginBtn.click();
		//quitting the browser session
		chdriver.quit();
	};

	@Test
	private void testcase01() {
		System.out.println("Test Case 01");
	}

	@Test
	private void testcase02() {
		System.out.println("Test Case 02");

	}

	@Test
	private void testcase03() {
		System.out.println("Test Case 03");

	}

	@Test
	private void testcase04() {
		System.out.println("Test Case 04");

	}

	@Test
	private void testcase05() {
		System.out.println("Test Case 05");

	}
}
