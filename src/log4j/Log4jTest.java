package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4jTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		Logger logger = Logger.getLogger("Log4jTest");		
		PropertyConfigurator.configure("log4j.properties");
		
		String url = "https://www.saucedemo.com/"; 
		
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");
		logger.info("System properties set for chrome browser.");
				
		WebDriver driver = new ChromeDriver();
		logger.info("Chrome browser is initialized.");
		
		driver.manage().window().maximize();
		logger.info("windows is maximized.");
		
		driver.get(url);
		logger.info("navigated to " + url); 
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		logger.info("Found element for username and send user name." );
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		logger.info("sent password.");
		
		driver.findElement(By.id("login-button")).click(); 
		logger.info("clicked on login button");
		
		String titleExpected = "Swag Labs"; 
		
		String titleActual = driver.getTitle();
		
		
	
		
		Thread.sleep(2000);
		
		if (titleExpected.equalsIgnoreCase(titleActual.toLowerCase())) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		
		driver.quit(); 
		
		
		
	}

}
