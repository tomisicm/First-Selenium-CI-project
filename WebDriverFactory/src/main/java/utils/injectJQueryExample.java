package utils;




import com.google.common.io.Resources;
import org.apache.commons.io.Charsets;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URL;


public class injectJQueryExample {

	public static void enablejQuery(JavascriptExecutor js) throws Exception{
        String readyState = js.executeScript("return document.readyState").toString();
       
        System.out.println("Is Jquery loaded......" + isjQueryLoaded(js));
        if(!isjQueryLoaded(js)) {
        	
        	URL jqueryUrl = Resources.getResource("jquery-3.3.1.min.js");
            System.out.println(jqueryUrl.getPath());
            String jqueryText = Resources.toString(jqueryUrl, Charsets.UTF_8);
            js.executeScript(jqueryText);
        }
        System.out.println("Is Jquery loaded......" + isjQueryLoaded(js));
    }

	public static Boolean isjQueryLoaded(JavascriptExecutor js) throws Exception {
        return (Boolean) js.executeScript("return !!window.jQuery;");
    }
	
	public static void main(String[] args) {
		
		// http://exploreselenium.com/selenium/run-jquery-in-selenium-webdriver/
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mtomisic\\eclipse-workspace\\Selenium\\Utils\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

	    driver.get("http://google.com");

		JavascriptExecutor js;

	    WebElement googleTxtBox = driver.findElement(By.id("lst-ib"));
	    
	    	        
	    
	    js = (JavascriptExecutor)driver;
	    
	    
	    try 
	    {
			injectJQueryExample.enablejQuery(js);
		} 
	    catch (Exception e) 
	    {
			e.printStackTrace();
		}
	    
	    googleTxtBox.sendKeys("lenovo laptop");
	    googleTxtBox.sendKeys(Keys.ENTER);
	    
	    
	    js.executeScript("window.scrollBy(0,350)");
	    
	    

	}

}
