package karteautobuske.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageActions {
	
	WebDriver driver;
	
	@FindBy(id = "login_email")
	private WebElement loginEmail;
	@FindBy(id = "login_password")
	private WebElement loginPassword;
	@FindBy(id = "login_event")
	private WebElement loginButton;
	
	@FindBy(css=".my-profile-actions a")
	public WebElement logoutButton;
	
	//INSTANTIATE
	public LoginPageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// EXCEPTIONS ARE MISSING
	
	
	public void logOut() {
		try {
			logoutButton.click();
		}
		catch (NoSuchElementException e) {
			//MAKE A SCREENSHOT
			//LOG
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logIn(String username, String password) {	
		try {
			loginEmail.sendKeys(username);
			loginButton.sendKeys(password);
			loginButton.click();
		} 
		catch (NoSuchElementException e) {
			//MAKE A SCREENSHOT
			//LOG
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
