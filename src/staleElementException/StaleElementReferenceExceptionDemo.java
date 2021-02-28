package staleElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceExceptionDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * Stale means old, decayed, no longer fresh. 
		 * in selenium, old element or no longer available element. 
		 * to handle, put it in try catch block and refresh it as below application. 
		 * 
		 */
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver"); 
		
		ChromeDriver driver = new ChromeDriver(); 
		
		driver.get("https://opensource-demo.orangehrmlive.com/"); 
		
		driver.manage().window().maximize(); 
		
		Thread.sleep(3000);
		
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
		
		link.click(); 
		Thread.sleep(1000);
		
		driver.navigate().back(); 
		
		Thread.sleep(3000);
		
		try {
			System.out.println("in try block");
			link.click(); 
		} catch(StaleElementReferenceException e) {
			System.out.println("in catch block");
			link = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
			link.click(); 
		}
		
		
		
		
		
	}

}
