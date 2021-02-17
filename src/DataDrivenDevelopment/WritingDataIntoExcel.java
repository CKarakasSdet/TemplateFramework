package DataDrivenDevelopment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
	
		FileOutputStream file = new FileOutputStream(".//Data/EmployeeSalaryData2.xlsx"); 
		
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		XSSFSheet sheetCreated = workbook.createSheet("ExternalEntry");
		
		for(int i=0; i< 5; i++) {
			
			XSSFRow row = sheetCreated.createRow(i); 
			
			for(int j=0; j<4; j++) {
				row.createCell(j).setCellValue("xyz");
			}
			
		}
		
		workbook.write(file);
		
		workbook.close();
		file.close(); 
	}

}
