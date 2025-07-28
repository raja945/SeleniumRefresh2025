package org.TestNGframework;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG01_Annotations {
	
	@BeforeSuite
	private void BeforeSuite() {
		System.out.println("Before Suite:D");
	}
	@AfterSuite
	private void AfterSuite() {
		System.out.println("After Suite:D");
	}
	
	@Test
	private void testcase01() {
		System.out.println("Test Case 01");
	}

	@Test (priority  = 1)
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
