package actionClassTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utilities.ActionUtils;



public class ActionClass_Resizable {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO: check this later on again. it did not work as expected. 

		String url = "https://jqueryui.com/resizable/";

		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(url);
		
		driver.switchTo().frame(0); 
		
		
		
		
		WebElement resize = driver.findElement(By.xpath("//*[@id='resizable']/div[3]")); 
		
		Actions actions = new Actions(driver); 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		
		Thread.sleep(3000);
		
		actions.moveToElement(resize).dragAndDropBy(resize, 100, 100).build().perform(); 
		 
		
		Thread.sleep(4000);
		
		
		driver.quit(); 

	}

}
