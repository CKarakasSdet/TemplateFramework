package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

	public static String sheetName = "dataInfo";
	public static String pathToFile = ".//Data/EmployeeSalaryData.xlsx";
	public static int rowNumber = 0;

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
					break;
				}
			}
		}
		workbook.close();
		file.close();
		return fieldValue;

	}

	/**
	 * This method allows us to write test results into a specific field's
	 * (column's) cell.
	 * 
	 * @param getFromField
	 * @param rowNumber
	 * @param writeIntoField
	 * @param result
	 * @throws IOException
	 */
	public static void setCellValueForResult(String getFromField, int rowNumber, String writeIntoField, String result)
			throws IOException {
		FileInputStream fileInput = new FileInputStream(pathToFile);
		XSSFWorkbook workbookInput = new XSSFWorkbook(fileInput);
		XSSFSheet sheetInput = workbookInput.getSheet(sheetName);
		String getFromFieldValue = "";
		int getFromColumnNumber = -1;
		if (rowNumber < 1 || rowNumber > getRowCount(sheetInput)) {
			System.out.println("Row number is out of bound for the value of " + rowNumber + ".");
		} else {
			for (int i = 0; i < getColumnCount(sheetInput); i++) {
				if (sheetInput.getRow(0).getCell(i).getStringCellValue().equals(getFromField)) {
					getFromFieldValue = sheetInput.getRow(rowNumber).getCell(i).getStringCellValue();
					getFromColumnNumber = i;
					break;
				}
			}
		}
		System.out.println("Looking for getFromFieldValue = " + getFromFieldValue);
		System.out.println("Looking for columnNumber = " + getFromColumnNumber);
		if (getFromColumnNumber == -1) {
			System.out.println("The value for field value = " + getFromField + " is not present.");
		} else {
			
			String writeIntoFieldValue = ""; 
			int writeIntoColumnIndex = -1;
			for (int i = 0; i < getColumnCount(sheetInput); i++) {
				if (sheetInput.getRow(0).getCell(i) != null &&  sheetInput.getRow(0).getCell(i).getStringCellValue().equals(writeIntoField) ) {
					System.out.println("i2 = " + i );
					System.out.println("writeIntoField = " + writeIntoField );
					writeIntoFieldValue = result;
					writeIntoColumnIndex = i;
					break;
				}
			}

			System.out.println("Looking for writeIntoField = " + writeIntoField);
			System.out.println("Will write writeIntoFieldValue = " + writeIntoFieldValue);
			System.out.println("Looking for writeIntoColumnNumber = " + writeIntoColumnIndex);

			if (writeIntoColumnIndex == -1) {
				System.out.println(
						"The value for writeIntoColumnNumber is " + writeIntoColumnIndex + " and it is not valid.");
				System.out.println(
						"The writeIntoField is " + writeIntoField + " and it is not present. Therefore, cannot write writeIntoFieldValue.");
				
				
			} else {
				
				FileOutputStream fileOut = new FileOutputStream(pathToFile);
				sheetInput.getRow(rowNumber).createCell(writeIntoColumnIndex).setCellValue(result);
				workbookInput.write(fileOut);
				workbookInput.close();
				fileInput.close();
				fileOut.close();
				System.out.println("Successfully written the data. Please check for the results. ");
			}
			
			
			
		}
	}

	/**
	 * This method allows us to write into any specified cell for given row number
	 * and column number. Warning: if the specified cell is not empty, we will not
	 * be able to write into it.
	 * 
	 * @param rowNumber
	 * @param columnNumber
	 * @param text
	 * @throws IOException
	 */
	public void setCellValue(int rowNumber, int columnNumber, String text) throws IOException {
		FileInputStream fileInput = new FileInputStream(pathToFile);
		XSSFWorkbook workbookInput = new XSSFWorkbook(fileInput);
		XSSFSheet sheetInput = workbookInput.getSheet(sheetName);
		if (columnNumber < 1) {
			System.out.println("Invalid column number for " + columnNumber + ".");
		} else {

			if (sheetInput.getRow(rowNumber).getCell(columnNumber) != null) {
				System.out.println("Cell value for row number = " + rowNumber + " and column number = " + columnNumber
						+ " is NOT EMPTY.");
				System.out.println("Present value for row number = " + rowNumber + " and column number = "
						+ columnNumber + " is " + sheetInput.getRow(rowNumber).getCell(columnNumber));
			} else {

				FileOutputStream fileOut = new FileOutputStream(pathToFile);
				sheetInput.getRow(rowNumber).createCell(columnNumber).setCellValue(text);
				workbookInput.write(fileOut);
				workbookInput.close();
				fileInput.close();
				fileOut.close();
				System.out.println(
						"Written value for row number = " + rowNumber + " and column number = " + columnNumber + " is "
								+ sheetInput.getRow(rowNumber).getCell(columnNumber).getStringCellValue().toString());
			}
		}
	}

	/**
	 * This method allows us to write into any specified cell for given row number
	 * and column number. If we do not want to check whether the cell is empty, and
	 * want to overwrite, we will set the boolean overwrite parameter to true.
	 * 
	 * @param rowNumber
	 * @param columnNumber
	 * @param text
	 * @param overwrite
	 * @throws IOException
	 */
	public void setCellValue(int rowNumber, int columnNumber, String text, boolean overwrite) throws IOException {
		FileInputStream fileInput = new FileInputStream(pathToFile);
		XSSFWorkbook workbookInput = new XSSFWorkbook(fileInput);
		XSSFSheet sheetInput = workbookInput.getSheet(sheetName);
		if (columnNumber < 1) {
			System.out.println("Invalid column number for " + columnNumber + ".");
		} else {

			if (sheetInput.getRow(rowNumber).getCell(columnNumber) != null && overwrite == false) {
				System.out.println("Cell value for row number = " + rowNumber + " and column number = " + columnNumber
						+ " is NOT EMPTY.");
				System.out.println("Present value for row number = " + rowNumber + " and column number = "
						+ columnNumber + " is " + sheetInput.getRow(rowNumber).getCell(columnNumber));
			} else {

				FileOutputStream fileOut = new FileOutputStream(pathToFile);
				sheetInput.getRow(rowNumber).createCell(columnNumber).setCellValue("\"" + text + "\"");
				workbookInput.write(fileOut);
				workbookInput.close();
				fileInput.close();
				fileOut.close();
				System.out.println(
						"Written value for row number = " + rowNumber + " and column number = " + columnNumber + " is "
								+ sheetInput.getRow(rowNumber).getCell(columnNumber).getStringCellValue().toString());
			}
		}
	}

}
