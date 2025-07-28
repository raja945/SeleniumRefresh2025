package mvn_framework;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MavenBuild {
	
	public static void main(String[] args) {
		ExtentReports extReports;
		ExtentSparkReporter htmlReport;
		ExtentTest testcase;
		extReports = new ExtentReports();
		htmlReport = new ExtentSparkReporter("testngreport.html");
		extReports.attachReporter(htmlReport);
		testcase = extReports.createTest("To check mavenBuild");
		MavenBuild mv = new MavenBuild();
		mv.practiceSiteLogin("student", "password");
		testcase.log(Status.INFO, "Test case Passed");
		extReports.flush();
	
	}
	
	public void practiceSiteLogin(String unameValue, String pwordValue) {
		WebDriver chdriver;
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
}
