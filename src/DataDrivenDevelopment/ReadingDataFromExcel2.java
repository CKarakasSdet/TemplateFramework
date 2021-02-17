package DataDrivenDevelopment;

import java.io.IOException;
import utilities.ExcelUtils;

public class ReadingDataFromExcel2 {

	public static void main(String[] args) throws IOException {
		
		
		 String val = ExcelUtils.getFieldValue( "EMAIL", 5);
		 System.out.println(val.toString().toLowerCase());
		
		
	}

}
