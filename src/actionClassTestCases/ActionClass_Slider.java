package actionClassTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_Slider {

	public static void main(String[] args) throws InterruptedException {

		String url = "http://testautomationpractice.blogspot.com/";

		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(url);
		
		Actions actions = new Actions(driver); 
		
		
		WebElement slider = driver.findElement(By.id("slider")); 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		
		Thread.sleep(3000);
		
		actions.moveToElement(slider).dragAndDropBy(slider, 40, 0).build().perform(); 
		 
		
		Thread.sleep(4000);
		
		
		driver.quit(); 

	}

}
