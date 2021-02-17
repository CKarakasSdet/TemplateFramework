package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

	private static XSSFWorkbook workbook;
	private static int rowNumber ;
	private static XSSFSheet sheet ;
	private static String sheetName = "dataInfo"; 



	public static int getRowCount(XSSFSheet sheet) {

		return sheet.getLastRowNum();

	}

	public static int getColumnCount(XSSFSheet sheet) {
		return sheet.getRow(0).getLastCellNum();
	}

	public static String getFieldValue(String field, int rowNumber) throws IOException {

		String pathToFile = ".//Data/EmployeeSalaryData.xlsx";

		FileInputStream file = new FileInputStream(pathToFile);

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//sheet = workbook.getSheet(sheetName);

		//int rowNumber = 4;
		String returnValue = "";
		if (rowNumber < 1 || rowNumber > getRowCount(sheet)) {
			System.out.println("Row number is out of bound for the value of " + rowNumber + ".");
		} else {

			for (int i = 0; i < getColumnCount(sheet); i++) {
				if (sheet.getRow(0).getCell(i).getStringCellValue().equals(field)) {
					returnValue = sheet.getRow(rowNumber).getCell(i).getStringCellValue();
				}
			}

		}
		return returnValue;

	}
}
