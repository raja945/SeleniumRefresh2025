package org.pom.SeleniumBase;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Baseclass {
	protected WebDriver driver;
	@BeforeMethod
	public void browserLaunch() throws InterruptedException{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().wait(2000); //implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
	}
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
}
