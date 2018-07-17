package factory.karteautobuske;

import org.testng.annotations.Factory;
import karteautobuske.bookingTests;

public class BookingRegressionTFactory {
	
	@Factory
	public Object[] factoryMethod(){
	
		return new Object[] {
			
			new bookingTests("Novi Sad", "Berlin"),
			new bookingTests("Beograd", "Berlin")
				
		};
	
	

	}
}