package org.TestNGframework;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestNG02_ExtentReport {
	ExtentReports extReports;
	ExtentSparkReporter htmlReport;
	ExtentTest testcase;
	
	@BeforeTest
	public void browserLaunch() {
		extReports = new ExtentReports();
		htmlReport = new ExtentSparkReporter("testngreport.html");
		extReports.attachReporter(htmlReport);
	}
	@Test(priority  = 4)
	private void testcase01() {
		testcase = extReports.createTest("test case 01");
		assertEquals("1", "1","Test Passed");
		testcase.log(Status.INFO, "Test case done");
		testcase.log(Status.PASS, "Test case Passed");
	}

	@Test(priority  = 5 , enabled=true)
	private void testcase02() {
		testcase = extReports.createTest("test case 02");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(true, false);
		System.out.println("After Soft assert");
		testcase.info("Info passed");
		softAssert.assertAll();

	}

	@Test(priority  = 6)
	private void testcase03() {
		testcase = extReports.createTest("test case 03");
		System.out.println("Class2 Test Case 03");

	}

	@Test(priority = 2)
	private void testcase04() {
		testcase = extReports.createTest("test case 04");
		System.out.println("Class2 Test Case 04");

	}

	@Test(priority = 3)
	private void testcase05() {
		testcase = extReports.createTest("test case 05");
		System.out.println("Class2 Test Case 05");

	}
	@AfterTest
	public void closeBrowser() {
		extReports.flush();
	}
}
