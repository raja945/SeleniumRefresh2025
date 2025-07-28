package dd_Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.Sheet;

public class DDF03_jxlDataDrivenexccelInput {
	WebDriver chdriver;

	/*
	 * @DataProvider(name="loginDataprovider") private String[][]
	 * loginDaloginDatataprovider() { return new String [][] {{ "student",
	 * "Password123" }, { "student_invalid", "Password123" }, { "student",
	 * "Password123_invalid" }, { "un_invalid", "pw_invalid" }}; }
	 */
	
	@DataProvider(name="loginDataprovider") 
	public String[][] loginDataprovider() throws BiffException, IOException{
		
//		String[][] data = getExcelData();
//		return data;
		return getExcelData();
	}

	public String[][] getExcelData() throws BiffException, IOException {
		String excelPath = "C:\\Users\\ganap\\OneDrive\\Documents\\loginDataTest_selenium.xls";
		FileInputStream loginDataEx = new FileInputStream(excelPath);
		Workbook wb = Workbook.getWorkbook(loginDataEx);
		Sheet sh = wb.getSheet(0);
		int rowCount = sh.getRows();
		int columnCount = sh.getColumns();

		String cellData[][] = new String[rowCount - 1][columnCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				cellData[i - 1][j] = sh.getCell(j, i).getContents();
				
			}
		}
		System.out.println(Arrays.deepToString(cellData));
		return cellData;
	}

	@BeforeTest
	public void browserLaunch() {
		// TODO Auto-generated method stub
		ChromeOptions choptions = new ChromeOptions();
		choptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		chdriver = new ChromeDriver(choptions);
		chdriver.manage().window().maximize();
		System.out.println(choptions.getBrowserName() + "browser launched successfully");
		chdriver.navigate().to("https://practicetestautomation.com/practice-test-login/");
	}
	@Test(dataProvider = "loginDataprovider")
	public void practiceSiteLogin(String unameValue, String pwordValue) {
		
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
		
		
	}
	@AfterTest
	public void closeBrowser() {
		// quitting the browser session
		chdriver.quit();
	}
}
