package dataDrivenDevelopment;

import java.io.IOException;
import utilities.ExcelUtils;

public class ReadingDataFromExcel2 extends ExcelUtils {

	public static void main(String[] args) throws IOException {

		rowNumber = 10 ;
		
		String val = ExcelUtils.getFieldValue("EMAIL", rowNumber);
		
		System.out.println("val = "+val.toString());
		
		System.out.println("===========");
		
		
		String expVal = "NEIOENLLEN@gmail.com"; 
		
		if(val.equals(expVal)) {
			ExcelUtils.setCellValueForResult("EMAIL", rowNumber, "RESULT2", "Passed");
		} else {
			ExcelUtils.setCellValueForResult("EMAIL", rowNumber, "RESULT2","Failed");
		}
		
		

	}

}
