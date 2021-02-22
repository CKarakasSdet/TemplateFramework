package sikuli_fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikuli_FileUpload {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.findElement(By.xpath("//*[@id='imagesrc']")).click();
		
		
		
		Screen screen = new Screen(); 
		
		Pattern fileInputTextbox = new Pattern(""); 
		
		Pattern openButton = new Pattern(""); 
		
		
		
		
		
		
		
		
		
		

	}

}
