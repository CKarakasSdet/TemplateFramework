package testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DealingWithBROKENLinks {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		Thread.sleep(3000);
		
		List<WebElement> links = driver.findElements(By.tagName("a")) ;
		
		int numberOfLinks = links.size(); 
		
		System.out.println("Number of Links = "+numberOfLinks);
		
		
		for(int i=0; i<links.size(); i++) 
		{
			WebElement element = links.get(i); 
			String url = element.getAttribute("href"); 
			
			URL link = new URL(url); 
			
			
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			
			Thread.sleep(2000);
			
			httpConn.connect(); 
			
			int resCode = httpConn.getResponseCode();
			
			if(resCode >= 400) {
				System.out.println("Broken link: " + url);
			} else {
				System.out.println("Safe link: " + url );
			}
			
			
		}
		
		driver.quit(); 

	}

}
