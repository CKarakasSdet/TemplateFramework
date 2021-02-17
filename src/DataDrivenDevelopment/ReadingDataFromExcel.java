package DataDrivenDevelopment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		String sheetName = "dataSalary";
	
		FileInputStream file = new FileInputStream(".//Data/EmployeeSalaryData.xlsx"); 
		
		XSSFWorkbook workbook = new XSSFWorkbook(file); 
		
		XSSFSheet sheet = workbook.getSheet(sheetName); 
		//XSSFSheet sheet = workbook.getSheetAt(0);  // to get the sheet by index 
		
		int rowCount = sheet.getLastRowNum();
		
		int columnCount = sheet.getRow(0).getLastCellNum() ;
		
		
		for(int i=0; i< rowCount; i++) 
		{
			  XSSFRow currentRow =  sheet.getRow(i);  
			  
			  for(int j=0; j<columnCount; j++) {
				  
				  System.out.print(currentRow.getCell(j).toString() + " - "); 
				  
			  }
			  
			  System.out.println();
			  
		}
		
		file.close(); 
		workbook.close(); 
	}

}
