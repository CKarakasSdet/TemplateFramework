package SeleniumSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumNavigation {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");		
		//System.setProperty("webdriver.gecko.driver", ".//Drivers/geckodriver");
		
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click(); 
		
		Thread.sleep(2000);
		
		driver.get("https://www.google.com/");
		
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		
		
		
		// driver.quit(); 
		
		
		

	}

}
