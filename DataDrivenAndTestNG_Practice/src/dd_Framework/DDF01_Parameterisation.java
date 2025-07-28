package dd_Framework;

import java.time.Duration;

import org.DDF.utils.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DDF01_Parameterisation extends utils {
	long startTime;
	long endTime;
	WebDriver chdriver;
	ChromeOptions choptions;
	// This test(DDF_01) deals with Parameter annotation
	//DDF_02 deals with DataProvider annotation
	
	@Test
	@Parameters({"url"})
	public void practiceSiteLogin(String url) {
		chdriver.navigate().to(url);
		// wait for the page to load
		Wait<WebDriver> wait = new FluentWait<WebDriver>(chdriver).withTimeout(Duration.ofSeconds(30)) // Maximum time
				.pollingEvery(Duration.ofSeconds(5)) // Check every 5 seconds
				.ignoring(NoSuchElementException.class);
		WebElement username = chdriver.findElement(By.id("username"));
		wait.until(driver -> username);
		// Entering username
		username.sendKeys("student");
		// Locating and entering password
		WebElement password = chdriver.findElement(By.name("password"));
		password.sendKeys("Password123");
		// Clicking on Login Btn
		WebElement loginBtn = chdriver.findElement(By.id("submit"));
		loginBtn.click();
		// wait for the page to load fully
		WebElement logoutBtn = chdriver.findElement(By.xpath("//a[text()='Log out']"));
		wait.until(driver -> logoutBtn);

		// Clicking on logout Btn
		logoutBtn.click();
		// Locating webelement again to avoid stale element exception
		WebElement username1 = chdriver.findElement(By.id("username"));
		// wait for the login page to load
		wait.until(driver -> username1);

	};

	@AfterSuite
	public void closeBrowser() {
		endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		int intTime = (int) totalTime;
		System.out.println("TT : " + intTime);
		chdriver.quit();
		System.out.println(choptions.getBrowserName() + "browser closed successfully");
	};

	@BeforeSuite
	public void browserLaunch() {
		choptions = new ChromeOptions();
		choptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		chdriver = new ChromeDriver(choptions);
		//chdriver.manage().window().maximize();
		System.out.println(choptions.getBrowserName() + "browser launched successfully");
	};

}
