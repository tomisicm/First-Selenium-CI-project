package basicstests;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;

public class date {

	public static void main(String[] args) {
		
		// https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
		// http://tutorials.jenkov.com/java-date-time/datetimeformatter.html
		// https://beginnersbook.com/2017/11/java-datetimeformatter/
		// https://javabeat.net/java-8-datetimeformatter/
		
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String text = date.format(formatter);
		
		LocalDate parsedDate = LocalDate.parse(text, formatter);

		System.out.println(text);
		
	}
	
	
}
