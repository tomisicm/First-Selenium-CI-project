package karteautobuske;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import driversetup.DriverFactory;
import karteautobuske.pom.HomePageActions;
import karteautobuske.pom.ReservationDataPageActions;
import karteautobuske.pom.ReservationResultPageActions;


public class bookingTests extends DriverFactory {
	
	
	/** SETUP APP USER DATA **/
	public static String url = "http://p.sixsentix.com/ticketbooking/";
	
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
	
	
	
	/** TEST RESERVATION - HAPPY PATH
	 * GIVEN:  
	 *** destination
	 * WHEN: 
	 *** reservation of the first available line is done
	 * THEN: 
	 *** verify ticked is reserved 
	 **/
	
	@Test
	public void happyPath001() throws Exception {
	
		WebDriver driver = DriverFactory.getDriver();
		
		driver.get(url);
		
		
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
