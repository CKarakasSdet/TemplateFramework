package SeleniumSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUsefulMethods {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");		
		//System.setProperty("webdriver.gecko.driver", ".//Drivers/geckodriver");
		
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("someemail");
		
		driver.findElement(By.id("pass")).sendKeys("somepass"); 
		
		driver.findElement(By.id("u_0_d_zA")).click(); 
	
		
		Thread.sleep(2000);
		
		
		
	    //driver.quit(); 
		
		
		

	}

}
