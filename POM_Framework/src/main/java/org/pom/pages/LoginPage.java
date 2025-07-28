package org.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pom.Bys.LoginPageBys;
import org.pom.SeleniumBase.Baseclass;

public class LoginPage extends Baseclass{
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement userName() {return driver.findElement(LoginPageBys.userName);}
	public WebElement passWord() {return driver.findElement(LoginPageBys.passWord);}
	public WebElement loginBtn() {return driver.findElement(LoginPageBys.loginBtn);}
	public WebElement logoutLbl() {return driver.findElement(LoginPageBys.logoutLbl);}
	/*
	*//**
		 * @description - username field
		 * @param username - pass the user id
		 * @return
		 */
	/*
	 * public void enterUsername(String usernameValue) { WebElement username =
	 * driver.findElement(By.id("username")); username.sendKeys(usernameValue); }
	 *//**
		 * @description - password field
		 * @param password - pass the password
		 * @return
		 */
	/*
	 * public void enterPassword(String passwordValue) { WebElement password =
	 * driver.findElement(By.name("password")); password.sendKeys(passwordValue); }
	 *//**
		 * @description - loginBtn field
		 * @param loginBtn - click loginbtn
		 * @return
		 */
	/*
	 * public void clickLoginBtn() { WebElement loginBtn =
	 * driver.findElement(By.id("submit")); loginBtn.click(); }
	 *//**
		 * 
		 * @description - get logout label
		 *//*
			 * public boolean getlogoutLabel() { return
			 * driver.findElement(By.xpath("//*[text()='Log out']")).isDisplayed(); }
			 * 
			 */
	
	
	//Executable Methods
	/**
	 * @description - login to the application with the credentials
	 */
	public void loginUser(String usernameValue, String PasswordValue) {
		/*
		 * enterUsername(usernameValue); enterPassword(PasswordValue); clickLoginBtn();
		 */
		userName().sendKeys(usernameValue);
		passWord().sendKeys(PasswordValue);
		loginBtn().click();
		
	}
}
