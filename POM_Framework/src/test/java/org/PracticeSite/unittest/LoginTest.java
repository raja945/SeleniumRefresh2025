package org.PracticeSite.unittest;
import org.pom.SeleniumBase.Baseclass;
import org.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Baseclass{
	
	@Test
	public void VerifyLoginTest(){
///		this chain calling can be done when the methods of the loginpage class return type is same
//		new LoginPage().enterUsername("student").enterPassword("Password123").clickLoginBtn();
	 
/// 	The following script is an example of not using page factory class as page facotry is deprecated	
		LoginPage lp = new LoginPage(driver);
		/*
		 * lp.enterUsername("student"); lp.enterPassword("password123");
		 * lp.clickLoginBtn();
		 */
		lp.loginUser("student", "password123");
		Assert.assertTrue(lp.logoutLbl().isDisplayed(),"Loggedin Successfully");
		System.out.println("Test Passed");
	}


}
