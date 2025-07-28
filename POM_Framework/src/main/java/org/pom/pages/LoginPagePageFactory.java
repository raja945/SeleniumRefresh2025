package org.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.pom.SeleniumBase.Baseclass;

public class LoginPagePageFactory  extends Baseclass{
	
	  /// Locators by using Page Factory class
	  
	  @FindBy(how=How.ID, using="username") 
	  public static WebElement username1;
	  
	  @FindBy(how=How.ID, using="password") 
	  public static WebElement password1;
	  
	  @FindBy(how=How.ID, using="submit") 
	  public static WebElement loginBtn1;
	 

}
