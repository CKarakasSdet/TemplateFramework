package actionClassTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_DragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		String url = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";

		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(url);
		
		Actions actions = new Actions(driver); 
		
		
		WebElement source = driver.findElement(By.id("box1")); 
		WebElement target = driver.findElement(By.id("box103")); 
		Thread.sleep(3000);		
		 
		 
		
		
		actions.dragAndDrop(source, target).release().build().perform(); 
		
		WebElement source2 = driver.findElement(By.id("box5")); 
		WebElement target2 = driver.findElement(By.id("box105")); 
		Thread.sleep(3000);	
		actions.clickAndHold(source2).moveToElement(target2).release().build().perform();
		
		Thread.sleep(4000);
		
		
		driver.quit(); 

	}

}
