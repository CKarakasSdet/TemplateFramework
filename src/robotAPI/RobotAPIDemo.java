package robotAPI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotAPIDemo {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		String url = "https://www.google.com/"; 
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");	
		WebDriver driver = new ChromeDriver();
		

		
		driver.get(url);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		
		Robot robot = new Robot(); 
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
				
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		
		
		robot.keyPress(KeyEvent.VK_ENTER); 
		
		Thread.sleep(4000);
		
		driver.quit();
		
		
		
		
		

	}

}
