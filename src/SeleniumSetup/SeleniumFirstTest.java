package SeleniumSetup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SeleniumFirstTest {

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
		
		String titleExpected = "Swag Labs"; 
		
		String titleActual = driver.getTitle();
		
		//Assert.assertEquals(titleActual, titleExpected);
	
		SoftAssert sa = new SoftAssert(); 
		sa.assertAll(); 
		
		Thread.sleep(2000);
		
		if (titleExpected.equalsIgnoreCase(titleActual.toLowerCase())) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		
		driver.quit(); 
		
		
		

	}

}
