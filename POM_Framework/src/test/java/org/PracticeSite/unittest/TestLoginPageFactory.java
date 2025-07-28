package org.PracticeSite.unittest;

import org.openqa.selenium.support.PageFactory;
import org.pom.SeleniumBase.Baseclass;
import org.pom.pages.LoginPagePageFactory;
import org.testng.annotations.Test;

public class TestLoginPageFactory extends Baseclass{
	
	@Test
	public void VerifyLoginTest(){
/// 	PageFactory : the following calls has been done with the help of pagefactory class
		PageFactory.initElements(driver, LoginPagePageFactory.class); // to initiate webdriver object in the Login page class as it is not having any object for webdriver
		LoginPagePageFactory.username1.sendKeys("student");
		LoginPagePageFactory.password1.sendKeys("Passowrd123");
		LoginPagePageFactory.loginBtn1.click();
		System.out.println("Test Passed");
	}


}
