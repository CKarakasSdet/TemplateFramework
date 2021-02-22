package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DealingWithCalendar {

	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver" );
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		// login 
		driver.findElement(By.id("txtUsername")).sendKeys("Admin"); 
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click(); 
		
		// navigate to admin > user management > users 
		driver.findElement(By.id("menu_admin_viewAdminModule")).click(); 
		Thread.sleep(1000);
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click(); 
		Thread.sleep(1000);
		driver.findElement(By.id("menu_recruitment_viewCandidates")).click(); 
		
		// click for date of application 
		driver.findElement(By.xpath("(//img[@class='ui-datepicker-trigger'])[1]")).click(); 
		
		Thread.sleep(4000);
		
		Select year = new Select ( driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));  // //select[@class='ui-datepicker-year']
		
		year.selectByVisibleText("2018"); 
		
		Select month = new Select ( driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"))); 
		
		month.selectByVisibleText("May");
		
		//driver.findElement(By.id("candidateSearch_fromDate")).clear(); 
		//driver.findElement(By.id("candidateSearch_fromDate")).sendKeys("2021-02-22");
		Thread.sleep(4000);
		
		
		driver.quit(); 
		
		System.out.println("Test is passed");

	}

}
