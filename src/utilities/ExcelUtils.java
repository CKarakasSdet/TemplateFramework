package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

	public static String sheetName = "dataInfo"; 
	public static String pathToFile = ".//Data/EmployeeSalaryData.xlsx";
	public static int rowNumber = 0 ;
	
	public static int getRowCount(XSSFSheet sheet) {
		return sheet.getLastRowNum();
	}

	public static int getColumnCount(XSSFSheet sheet) {
		return sheet.getRow(0).getLastCellNum();
	}

	public static String getFieldValue(String field, int rowNumber) throws IOException {		
		FileInputStream file = new FileInputStream(pathToFile);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		String fieldValue = "";
		if (rowNumber < 1 || rowNumber > getRowCount(sheet)) {
			System.out.println("Row number is out of bound for the value of " + rowNumber + ".");
		} else {
			for (int i = 0; i < getColumnCount(sheet); i++) {
				if (sheet.getRow(0).getCell(i).getStringCellValue().equals(field)) {
					fieldValue = sheet.getRow(rowNumber).getCell(i).getStringCellValue();
				}
			}
		}
		workbook.close(); 
		file.close(); 
		return fieldValue;

	}
	
	public static void setCellValueForResult(String field, int rowNumber, String result ) throws IOException {		
		FileInputStream fileInput = new FileInputStream(pathToFile); 		
		XSSFWorkbook workbookInput = new XSSFWorkbook(fileInput); 		
		XSSFSheet sheetInput = workbookInput.getSheet(sheetName); 				
		String fieldValue = "";
		int columnNumber = -1 ;
		if (rowNumber < 1 || rowNumber > getRowCount(sheetInput)) {
			System.out.println("Row number is out of bound for the value of " + rowNumber + ".");
		} else {
			for (int i = 0; i < getColumnCount(sheetInput); i++) {
				if (sheetInput.getRow(0).getCell(i).getStringCellValue().equals(field)) {
					fieldValue = sheetInput.getRow(rowNumber).getCell(i).getStringCellValue();
					columnNumber = i ;
				}
			}
		}		
		System.out.println("Looking for fieldValue = " + fieldValue);
		System.out.println("Looking for columnNumber = " + columnNumber );
		if(columnNumber == -1) {
			System.out.println("The value for field value = " + field + " is not present." );
		} else {					
		FileOutputStream fileOut = new FileOutputStream(pathToFile); 		
		sheetInput.getRow(rowNumber).createCell(columnNumber+1).setCellValue(result); 		
		workbookInput.write(fileOut);  		
		workbookInput.close();
		fileInput.close(); 				
		fileOut.close(); 		
		System.out.println("Successfully written the data. Please check for the results. ");	
		}
	}
	
	
}
