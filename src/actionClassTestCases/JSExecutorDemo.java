package actionClassTestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.JavaScriptUtils;

public class JSExecutorDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		String url = "https://www.twoplugs.com/"; 
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver"); 
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); 
		
		driver.get(url);
		
//		WebElement joinFree = driver.findElement(By.xpath("//header/div[1]/ul[1]/li[2]/a[1]/span[1]")); 
		
		// JavaScriptUtils.flash(joinFree, driver);
		
//		JavaScriptUtils.drawBorder(joinFree, driver);
		
//		File src =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
//		
//		File target = new File(".//Screenshots/twoplugs.png"); 
//		
//		FileUtils.copyFile(src, target);
//		
//		FileUtils.deleteQuietly(src);
				
//		System.out.println( JavaScriptUtils.getTitleByJavascript(driver) ); 
		
//		WebElement loginBtn = driver.findElement(By.xpath("//header/div[1]/ul[1]/li[2]/a[1]/span[1]")); 
		
//		JavaScriptUtils.clickElementByJavascript(loginBtn, driver);
//		Thread.sleep(1000);
		
//		JavaScriptUtils.generateAlert(driver, "clicked on Login button.");
//		Thread.sleep(1000);
//		driver.switchTo().alert().accept(); 
//		Thread.sleep(1000);
		
		// JavaScriptUtils.refreshByJavascript(driver); 
		
		//WebElement img = driver.findElement(By.xpath("//body/div[1]/section[4]/div[2]/ul[1]/li[1]/div[1]/img[1]")); 
		Thread.sleep(1000);
		
		//JavaScriptUtils.scrollIntoView(img, driver);
		
		JavaScriptUtils.scrollToBottomOfPage(driver); 
		Thread.sleep(3000);
		
		
		
		
		driver.quit(); 
		
		

	}

}
