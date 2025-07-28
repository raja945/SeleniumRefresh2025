package org.DDF.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class utils {
	
	public static WebElement waituntil(WebDriver driver, By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(Duration.ofSeconds(30))              // Maximum time to wait: 30 seconds
			    .pollingEvery(Duration.ofSeconds(5))              // Check every 5 seconds
			    .ignoring(NoSuchElementException.class);
		return wait.until(driverInstance -> driverInstance.findElement(locator));
		
        //wait.until(...) expects a function that takes 
        //	a WebDriver and returns some value (typically a WebElement, Boolean, etc.).
        //The lambda d -> d.findElement(locator) is shorthand for:
        
		/*
		 * new Function<WebDriver, WebElement>() { public WebElement apply(WebDriver d)
		 * { return d.findElement(locator); } }
		 */
    }
}
