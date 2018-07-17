package karteautobuske.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.AdditionalConditions;

public class HomePageActions {

	WebDriver driver;
	
	public HomePageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBys({ @FindBy(className="loginBtn"), @FindBy(css=".user-profile a")})
	@FindBy(className="loginBtn")
	private WebElement navToLoginPage;
	
	
	@FindBy(id="autocomplete_search_start")
	private WebElement startingDestination;
	//LI
	@FindBy(className="acdd_select_start")
	WebElement startingDestinationSuggested;

	
	@FindBy(id="autocomplete_search_final")
	private WebElement endDestination;
	//DIV with suggested LI
	@FindBy(className="acdd_select_final")
	WebElement endDestinationSuggested;
	
	
	@FindBy(id="search_for_available_tickets")
	WebElement reserveTickets;
	//DIV with suggested LI
	
	
	//LOGS AND SCREENSHOTS ARE MISSING
	
	
	public void navigateToLoginPage() {
		try {
			navToLoginPage.click();
		}
		catch (Exception e) {
			// SCREENSHOT
			//LOG
			e.printStackTrace();
		}
	}
	
	
	public void fillStartingDestination(String startingDestiation) {
		startingDestination.sendKeys(startingDestiation);
		try {
			(new WebDriverWait(driver, 15, 100)).until(AdditionalConditions.jQueryAJAXCallsHaveCompleted());
			startingDestinationSuggested.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex) {
			startingDestinationSuggested.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void fillEndingDestination(String endDestiation) {
		
		try {
		endDestination.sendKeys(endDestiation);
			try {
				(new WebDriverWait(driver, 15, 100)).until(AdditionalConditions.jQueryAJAXCallsHaveCompleted());
				endDestinationSuggested.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex) {
				endDestinationSuggested.click();
				}
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	
	// i could set this up so it enters date. convert date into string. execute script.
	public void fillDepartureDate() {							
		((JavascriptExecutor) driver)
			.executeScript("document.querySelector('#travel_date').value = '15.07.2018';");
	}
	
	public void buyTicket() {
		try {
			reserveTickets.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
	
	
	
}
