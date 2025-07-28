package dd_Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class DDF04DataDrivenUsingPOI {
	WebDriver chdriver;

	@DataProvider(name ="loginDataProvider")
	public Object[][] loginDataProvider() throws IOException {
		return readXlDataPOI();
	}
	
	
	public Object[][] readXlDataPOI() throws IOException {
		String xlPath = "C:\\Users\\ganap\\OneDrive\\Documents\\loginDataTest_selenium.xlsx";
		FileInputStream xlFile = new FileInputStream(xlPath);
		Workbook wb = new XSSFWorkbook(xlFile);
		Sheet sh = wb.getSheetAt(0);
		int rowCount = sh.getPhysicalNumberOfRows();
		int colCount = sh.getRow(rowCount-1).getLastCellNum();
		
		Object cellData[][]=new Object[rowCount-1][colCount];
		for (int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				Cell cell = sh.getRow(i).getCell(j);
				cellData [i-1][j] = cell.toString();
			}
		}
		wb.close();
		xlFile.close();
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
	@Test(dataProvider = "loginDataProvider")
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
