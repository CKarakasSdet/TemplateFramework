package recordingTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.ScreenRecorderUtil;

public class TestCase {

	WebDriver driver;

	@BeforeClass
	void setUp() {
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	void login() throws Exception {
		
		ScreenRecorderUtil.startRecord("login");
		// login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		// MOUSE OVER ACTION

		Actions act = new Actions(driver);

		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement userManagement = driver.findElement(By.id("menu_admin_UserManagement"));
		WebElement users = driver.findElement(By.id("menu_admin_viewSystemUsers"));

		act.moveToElement(admin).build().perform(); // mouse over to admin
		Thread.sleep(500);
		act.moveToElement(userManagement).build().perform(); // mouse over to user management
		Thread.sleep(500);
		act.moveToElement(users).click().build().perform(); // mouse over to users
		Thread.sleep(500);

		int rowCount = driver
				.findElements(By.xpath("html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr")).size();
		System.out.println("rowCount = " + rowCount);
		int statusCount = 0;

		for (int i = 1; i <= rowCount; i++) {
			String status = driver
					.findElement(By.xpath(
							"html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr[" + i + "]/td[5]"))
					.getText();
			if (status.equalsIgnoreCase("Enabled")) {
				statusCount++;
			}
		}

		System.out.println("Number of employees enabled is " + statusCount + ".");
		
		
		ScreenRecorderUtil.stopRecord(); 
	}

}
