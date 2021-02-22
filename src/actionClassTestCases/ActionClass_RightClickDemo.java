package actionClassTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_RightClickDemo {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://swisnl.github.io/jQuery-contextMenu/demo.html";

		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(url);
		
		Actions actions = new Actions(driver); 
		
		// following did not work when I used relative xpath. 
		WebElement clickMeBtn = driver.findElement(By.xpath("html/body/div/section/div/div/div/p/span")); 
		WebElement copyOption = driver.findElement(By.xpath("html/body/ul/li[3]")); 
				
		actions.contextClick(clickMeBtn).build().perform();
		
		actions.click(copyOption).build().perform(); 
		
		String text = driver.switchTo().alert().getText();
		
		if(text.equalsIgnoreCase("clicked: copy")) {
			System.out.println("Successfully cliked on copy.");
			Thread.sleep(2000);
			driver.switchTo().alert().accept(); 
		} else {
			System.out.println("could not click on copy.");
		}
		
		
		
		
		
		Thread.sleep(4000);
		
		
		driver.quit(); 

	}

}
