package aaaaaa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SetupGeckoDriverPathIgnore {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "D:\\mt\\eclipse-workspace\\AutobuskeKarte\\Utils\\geckodriver.exe");
		//File pathBinary = new File("D:\\Program files\\Mozilla firefox\\firefox.exe");
		//FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
		FirefoxOptions options = new FirefoxOptions();
		//options.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://www.google.com/");
		
		
		WebElement element = driver.findElement(By.name("q"));
		
		element.sendKeys("fsg");
		element.sendKeys(Keys.ENTER);
		
		driver.quit();
		
		
	}

}
