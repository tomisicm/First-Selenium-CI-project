package utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdditionalElementConditions {
	
	
	// negate for unavailability of an element
	private boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
		return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	private boolean isElementPresent2(WebDriver driver, By by) {
			
		if(driver.findElements(by).size()>0) 
			
			return true;
		
		return false;
	}
	
	
	
}
