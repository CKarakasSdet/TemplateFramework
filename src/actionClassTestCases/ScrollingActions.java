package actionClassTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingActions {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String url = "https://www.countries-ofthe-world.com/flags-of-the-world.html";
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		// scrolling by pixel 
		// js.executeScript("window.scrollBy(0,1000)", ""); 
		
		//WebElement flag = driver.findElement(By.xpath("//td[contains(text(),'Russia')]"));		
		//js.executeScript("arguments[0].scrollIntoView();", flag); 
		
		// scrolling to the bottom 
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)" );
		
		
		
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}
