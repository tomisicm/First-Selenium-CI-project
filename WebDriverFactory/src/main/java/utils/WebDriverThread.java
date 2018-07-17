package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static utils.DriverType.FIREFOX;
import static utils.DriverType.valueOf;

import java.net.MalformedURLException;

public class WebDriverThread {
	
	private WebDriver webdriver;
	private DriverType selectedDriverType;
	
	private final DriverType defaultDriverType = FIREFOX;
	
	private final String operatingSystem = System.getProperty("os.name").toUpperCase();
	private final String systemArchitecture = System.getProperty("os.arch");
	
	private final String browser = System.getProperty("browser").toUpperCase();
	
	
	public WebDriver getDriver() throws Exception {
		
		if (null == webdriver) {
			
			selectedDriverType = determineEffectiveDriverType();
			DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
			instantiateWebDriver(desiredCapabilities);
			System.setProperty("webdriver.gecko.driver", "D:\\mt\\eclipse-workspace\\WebDriverFactory\\Utils\\geckodriver");
						
		}
		
		return webdriver;

	}
	
	public void quitDriver() {
		
		if (null != webdriver) {
			
			webdriver.quit();
			webdriver = null;
		
		}
	}
	
	private DriverType determineEffectiveDriverType() {
		DriverType driverType = defaultDriverType;
			try {
				driverType = valueOf(browser);
			} 
			catch (IllegalArgumentException ignored) {
				System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
			} 
			catch (NullPointerException ignored) {
				System.err.println("No driver specified, defaulting to '" + driverType + "'...");
			}
	
		return driverType;
	
	}
	
	private void instantiateWebDriver(DesiredCapabilities desiredCapabilities) throws MalformedURLException {
		
			System.out.println(" ");
			System.out.println("Current Operating System: " +	operatingSystem);
			System.out.println("Current Architecture: " + 	systemArchitecture);
			System.out.println("Current Browser Selection: " + 	selectedDriverType);
			System.out.println(" ");
			//System.setProperty("webdriver.chrome.driver", "D:\\mt\\eclipse-workspace\\WebDriverFactory\\Utils\\geckodriver");
			webdriver = selectedDriverType.getWebDriverObject(desiredCapabilities);
		
	}
	
	
	
	
}
