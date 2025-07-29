package org.pom.SeleniumBase;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Baseclass {
	protected WebDriver driver;
	@BeforeMethod
	public void browserLaunch() throws InterruptedException{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		// Use the wait on an element conditionally, like:
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		
	}
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
}
