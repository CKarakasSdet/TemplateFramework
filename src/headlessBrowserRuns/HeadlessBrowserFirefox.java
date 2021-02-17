package headlessBrowserRuns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessBrowserFirefox {

	public static void main(String[] args) throws Exception {
			
		System.setProperty("webdriver.gecko.driver", ".//Drivers/geckodriver");
		
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		//firefoxOptions.setHeadless(true);
		
		firefoxOptions.addArguments("--headless"); 
		
		WebDriver driver = new FirefoxDriver(firefoxOptions); // need to pass the options parameter. 
		//WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click(); 
		
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
