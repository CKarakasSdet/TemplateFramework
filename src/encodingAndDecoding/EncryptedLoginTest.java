package encodingAndDecoding;

import org.apache.commons.net.util.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EncryptedLoginTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		driver.findElement(By.id("txtPassword")).sendKeys(decodeString("YWRtaW4xMjM="));

		driver.findElement(By.id("btnLogin")).click();

		Thread.sleep(3000);

		driver.quit();

	}

//	        encodedString = YWRtaW4xMjM=
//			decodedString = admin123

	static String decodeString(String password) {
		byte[] decodedString = Base64.decodeBase64(password);

		return new String(decodedString);
	}

}
