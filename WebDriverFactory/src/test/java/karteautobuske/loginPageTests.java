package karteautobuske;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import driversetup.DriverFactory;
import karteautobuske.pom.HomePageActions;
import karteautobuske.pom.LoginPageActions;
import utils.AdditionalConditions;

public class loginPageTests extends DriverFactory {
	
	
	/**
	 * Given: valid user (email and password)
	 * Then: login
	 * 
	 * TEST: Access for regular users who are looking for ticket and are willing to make reservations
		URL: jsut some app you want to test
		Regular User credentials: 
	 */
	
	public static String url = "http://p.sixsentix.com/ticketbooking/";
	public static String eMail = "validuser@gmail.com";
	public static String password = "validpassword";
	
	
	@Test
	public void f() throws Exception {
		  
		WebDriver driver = DriverFactory.getDriver();
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
		HomePageActions HomePage = new HomePageActions(driver);
		HomePage.navigateToLoginPage();
		
		LoginPageActions LoginPage = new LoginPageActions(driver);
		LoginPage.logIn(eMail, password);
		
		(new WebDriverWait(driver, 10, 200)).until(AdditionalConditions.jQueryAJAXCallsHaveCompleted());
		
		assertTrue(LoginPage.logoutButton.isDisplayed());
		
		LoginPage.logOut();
		
		driver.quit();
		
	  }

	
	
	
	
	
	
	
	
	
	
}
