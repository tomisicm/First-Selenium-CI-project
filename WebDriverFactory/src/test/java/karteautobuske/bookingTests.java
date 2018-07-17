package karteautobuske;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import karteautobuske.pom.HomePageActions;
import karteautobuske.pom.ReservationDataPageActions;
import karteautobuske.pom.ReservationResultPageActions;


public class bookingTests {
	
	
	/** SETUP APP USER DATA **/
	//public static String url = "valid site where you can test stuff";
	
	private String startLoc;
	private String endLoc;
	
	
	//INITIALIZE THE TEST
	public bookingTests(String startLoc, String endLoc) {
		this.startLoc = startLoc;
		this.endLoc = endLoc;
	}
	
	
	
	/** SETUP TEST DATA **/
	
	private String username = System.getProperty("user.name").toString();
	private String jmbg = "123123123123";
	private String passportID = "1111111111";
	
	WebDriver driver;
	
	
	@BeforeMethod
	@Parameters({"browser", "url"})
	public void setup(String browser, String url)
	{
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver","D:\\mt\\eclipse-workspace\\AutobuskeKarte\\Utils\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
		
			System.setProperty("webdriver.gecko.driver", "D:\\mt\\eclipse-workspace\\AutobuskeKarte\\Utils\\geckodriver.exe");			
			driver = new FirefoxDriver();
		}
		
		//		driver.manage().deleteAllCookies();		I think driver is clean
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	/** TEST RESERVATION - HAPPY PATH
	 * GIVEN:  
	 *** destination
	 * WHEN: 
	 *** reservation of the first available line is done
	 * THEN: 
	 *** verify ticked is reserved 
	 **/
	
	@Test
	public void happyPath001() {
	
		
		HomePageActions HomePage = new HomePageActions(driver);
		//LoginPageActions LoginPage = PageFactory.initElements(driver, LoginPageActions.class);

		//END LOC AND START LOC WILL BE INITIALIZED VIA Factory.
		HomePage.fillStartingDestination(startLoc);
		HomePage.fillEndingDestination(endLoc);
		HomePage.fillDepartureDate();
		HomePage.buyTicket();
		
		ReservationResultPageActions SearchPage = new ReservationResultPageActions(driver);
				
		SearchPage.reserveFirstAvailable();
		
		ReservationDataPageActions ReservationPage = new ReservationDataPageActions(driver);
		
		ReservationPage.setFirstnameAndLastname(username);
		ReservationPage.setInsurancePolicy();
		ReservationPage.setJMBG(jmbg);
		ReservationPage.setPassportID(passportID);
		
		ReservationPage.setContactInfo(username, username + "@gmail.com", "065 701 20 34", "Novi Sad, Bul. Osl 2");
		
		ReservationPage.selectPaymentOpt();
		
		ReservationPage.makeReservation();
		
		//VERIFY RESERVATION PROCESS IS SUCCESSFUL !
		
	}
	
	
	
	
	
	
}
