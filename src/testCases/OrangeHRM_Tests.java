package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author cahitkarakas
 * 
 * Test Case A: 
 * 1. loging to hrm orange 
 * 2. navigate to admin > user management > users 
 * 3. count employees whose status' are enabled 
 *
 */

public class OrangeHRM_Tests {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver" );
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		// login 
		driver.findElement(By.id("txtUsername")).sendKeys("Admin"); 
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click(); 
		
		driver.findElement(By.id("menu_admin_viewAdminModule")).click(); 
		Thread.sleep(1000);
		driver.findElement(By.id("menu_admin_UserManagement")).click(); 
		Thread.sleep(1000);
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click(); 
		
		int rowCount = driver.findElements(By.xpath("html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr")).size();
		System.out.println("rowCount = "+rowCount);
		int statusCount = 0 ; 
		
		for(int i=1 ; i<= rowCount; i++) {
			String status = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr["+ i +"]/td[5]")).getText() ; 
			if(status.equalsIgnoreCase("Enabled")) {
				statusCount++ ;
			}			
		}
				
		System.out.println("Number of employees enabled is " + statusCount + ".");		
		
		Thread.sleep(2000); 		
	
		driver.quit(); 

	}

}
