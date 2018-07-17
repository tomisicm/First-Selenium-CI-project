package karteautobuske.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	// THIS PAGE IS PAGE WITH RESULTS (AVAILABLE TICKETS)

public class ReservationDataPageActions {

	WebDriver driver;
	
	public ReservationDataPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "name_and_surname_1")
	WebElement nameAndSurname;

	@FindBy(id = "date_of_birth_1")
	WebElement dateOfBirth;

	//	NOTE: REVIEW LATER
	@FindBy(css = "#insurance_1_chzn a")
	WebElement insurancePolicy;
	@FindBy(css = "#insurance_1_chzn_o_1")
	WebElement insurancePolicyDD;
	
	@FindBy(id = "jmbg_1")
	WebElement JMBG;	
	@FindBy(id = "number_of_passport_1")
	WebElement PassportID;
	
	@FindBy(id = "contact_name")
	WebElement contactNameAndUSurname;	
	@FindBy(id = "contact_email")
	WebElement contactEmail;
	@FindBy(id = "contact_phone")
	WebElement contactPhone;
	@FindBy(id = "contact_address")
	WebElement contactAddress;
	
	
	//PAYMENT
	@FindBy(id = "pl-pou")
	WebElement paymentOption1;
	
	
	//RESERVE
	@FindBy(css = ".next-step.reservation_event")
	WebElement reservationBttn;
	
	
	public void setFirstnameAndLastname(String userData) {
		nameAndSurname.sendKeys(userData);
	}
	
	// document.querySelector("#insurance_1_chzn a span").innerText = "Ne";	can this be abused somehow ? => investigate later
	public void setInsurancePolicy() {
		insurancePolicy.click();
		insurancePolicyDD.click();
	}
	
	public void setJMBG(String jmbg) {
		JMBG.sendKeys(jmbg);
	}
	
	public void setPassportID(String passportID) {
		PassportID.sendKeys(passportID);
	}
	
	public void setContactInfo(String nameAndUsername, String ContactEmail, String ContactPhone, String ContactAddress) {
		contactNameAndUSurname.sendKeys(nameAndUsername);
		contactEmail.sendKeys(ContactEmail);
		contactPhone.sendKeys(ContactPhone);
		contactAddress.sendKeys(ContactAddress);
	}

	public void selectPaymentOpt() {
		paymentOption1.click();
	}
	
	public void makeReservation() {
		reservationBttn.click();
	}
	
	
}
