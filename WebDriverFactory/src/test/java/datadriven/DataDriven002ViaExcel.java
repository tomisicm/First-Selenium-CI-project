package datadriven;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelUtils;


public class DataDriven002ViaExcel {
	
	public static String DATALOCATION = "D:\\mt\\eclipse-workspace\\AutobuskeKarte\\target\\test-classes\\utils\\testdata\\testData.xlsx";
	
	@DataProvider	//(name="empLogin")
	public Object[][] testData() {
		
		Object[][] arrayObject = null;
		
		try {
			arrayObject = ExcelUtils.testDataSupplier(DATALOCATION);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayObject;
	}
	
	private WebDriver driver;
	

	
	
	@BeforeTest
	public void setUp() {
	
		System.setProperty("webdriver.chrome.driver","D:\\mt\\eclipse-workspace\\AutobuskeKarte\\Utils\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.seleniumacademy.com/cookbook/bmicalculator.html");
	
	}
	
	@Test(dataProvider = "testData")
	public void testBMICalculator(String height, String weight, String bmi, String category) {
	
		WebElement heightField = driver.findElement(By.name("heightCMS"));
		heightField.clear();
		heightField.sendKeys(height);
		
		WebElement weightField = driver.findElement(By.name("weightKg"));
		weightField.clear();
		weightField.sendKeys(weight);
	
		WebElement calculateButton = driver.findElement(By.id("Calculate"));
		calculateButton.click();
		
		WebElement bmiLabel = driver.findElement(By.name("bmi"));
		assertEquals(bmiLabel.getAttribute("value"), bmi);
		
		WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
		
		assertEquals(bmiCategoryLabel.getAttribute("value"), category);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	
	
	
	
	
	
	
	
	

}
