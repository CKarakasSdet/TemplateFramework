package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private static WebDriver driver;

	private Driver() {

	}

	public synchronized static WebDriver getDriver(String browser) {

		if (driver == null) {

			browser = browser == null ? ConfigurationReader.getProperty("browser") : browser;

			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "chromeHeadless":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

//			case "edgeHeadless" :
//				WebDriverManager.edgedriver().setup(); 
//				TODO: figure out for set headless. 

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			case "firefoxHeadless":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));

			default:
				throw new RuntimeException("Illegal browser type!");

			} // end of switch

		} // end of if

		return driver;
	}

	public static WebDriver getDriver() {
		return getDriver(null);
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
