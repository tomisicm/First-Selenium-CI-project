package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	/*
	 	https://www.geeksforgeeks.org/reading-writing-data-excel-file-using-apache-poi/
		http://www.testingbar.com/how-to-read-data-from-excel-file-using-apache-poi/
		http://www.codejava.net/coding/how-to-read-excel-files-in-java-using-apache-poi
		
		
		http://toolsqa.com/selenium-webdriver/data-driven-testing-excel-poi/   < SET CELL DATA
		http://learn-automation.com/read-and-write-excel-files-in-selenium/ < SET EXCEL DATA
		https://www.guru99.com/all-about-excel-in-selenium-poi-jxl.html
		https://www.callicoder.com/java-read-excel-file-apache-poi/ < different type of iteration
		
		https://stackoverflow.com/questions/47694914/how-to-read-data-from-excel-file-and-create-a-graph-using-java-or-groovy
	 */
	
	
	
	
	 public static Object[][] testDataSupplier(String filePath) throws Exception {
	 //file path where excel file placed, containing test data.
	  
		 filePath = "D:\\mt\\eclipse-workspace\\AutobuskeKarte\\target\\test-classes\\utils\\testdata\\testData.xlsx";
	  
		 FileInputStream fis = new FileInputStream(new File (filePath));
	  
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 
		 XSSFSheet sheet = workbook.getSheetAt(0);		//use get sheet via filename later
		 
		 int totalNumberOfRows = sheet.getLastRowNum()+1;
		 
		 int totalNumberOfCols = sheet.getRow(0).getLastCellNum();
	  
		 //create an object array. which will store the test data from excel file
		 Object[][] testdata = new Object[totalNumberOfRows][totalNumberOfCols];

	  
		 for (int i = 0; i < totalNumberOfRows; i++ )	{	 
			 for (int j = 0; j < totalNumberOfCols; j++)	{
			
				 testdata[i][j] =  sheet.getRow(i).getCell(j).toString();   
			 
			 }
		 }
		 
		 workbook.close();
		 
		 return testdata;
	 }

	
	
	
	
	
	
}
