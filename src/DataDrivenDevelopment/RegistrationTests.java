package DataDrivenDevelopment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTests {

	public static void main(String[] args) throws IOException {

		String sheetName = "dataInfo";

		FileInputStream file = new FileInputStream(".//Data/EmployeeSalaryData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet(sheetName);
		// XSSFSheet sheet = workbook.getSheetAt(0); // to get the sheet by index

		int rowCount = sheet.getLastRowNum();
		System.out.println("rowCount = " + rowCount);
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println("columnCount = " + columnCount);

		for (int row = 1; row <= rowCount; row++) {
			XSSFRow currentRow = sheet.getRow(row);

			String lastName = currentRow.getCell(2).getStringCellValue();
			String email = currentRow.getCell(3).getStringCellValue();

			System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");

			WebDriver driver = new ChromeDriver();
			// WebDriver driver = new FirefoxDriver();

			driver.manage().window().maximize();

			driver.get("https://www.saucedemo.com/");

			driver.findElement(By.id("user-name")).sendKeys(email);

			driver.findElement(By.id("password")).sendKeys(lastName);

			driver.findElement(By.id("login-button")).click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println();
			
			driver.close(); 

		}

		file.close();
		workbook.close();
	}

}
