package karteautobuske.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	// THIS PAGE IS PAGE WITH RESULTS (AVAILABLE TICKETS)

public class ReservationResultPageActions {

	WebDriver driver;
	
	// private String cssSelectorForLI = "ul.ticket-list li:nth-of-type(1)";
	
	public ReservationResultPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//** I SHOULD PROBABLY TRY MAKING CLASS WHICH WILL DESCRIBE LI (meaning, use PageFactory within PageFactory)
	//** METHODS WOULD TAKE (number) N ARGUMENT (N is lower than total count) 
	//** SO THAT FOR GIVEN N I CAN EASLY GET THE DATA WHICH DESCRIBE THE TICKET OFFER
	//** FOR NOW ILL SIMPLIFY EVERYTHING.
	
	@FindBy(css = "ul.ticket-list li a")
	WebElement reserveTicketBttn;
	
	//N would go here.
	@FindBy(css = "ul.ticket-list li:nth-of-type(1)")
	WebElement listItem1;
	

	@FindBy(css = "ul.ticket-list li:nth-of-type(1) p.time span.txt")
	WebElement listItemDate;

	@FindBy(css = "ul.ticket-list li:nth-of-type(1) p.stime span.green")
	WebElement listItemTime;
	
	@FindBy(css = "ul.ticket-list li:nth-of-type(1) p.company span.txt")
	WebElement listItemCompany;
	

	
	public void reserveFirstAvailable() {
		reserveTicketBttn.click();
	}
	
	public String getFirstAvailableDataDate() {
		return listItemDate.getText();
	}
	
	public String getFirstAvailableDataTime() {
		return listItemTime.getText();
	}

	public String getFirstAvailableDataCompany() {
		return listItemCompany.getText();
	}
	
	
	
	
	
	
}
