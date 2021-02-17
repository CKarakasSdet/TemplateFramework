package headlessBrowserRuns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowserChrome {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");		
		//System.setProperty("webdriver.gecko.driver", ".//Drivers/geckodriver");
		
		ChromeOptions chromeOptions = new ChromeOptions(); 
		
		// chromeOptions.setHeadless(true) ; 
		
		chromeOptions.addArguments("--headless"); 
		
		WebDriver driver = new ChromeDriver(chromeOptions); // need to pass the options parameter. 
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
