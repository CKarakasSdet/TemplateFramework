package cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesExamples {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://www.amazon.com/";
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		Set<Cookie> cookies = driver.manage().getCookies();

		System.out.println("number of cookies = " + cookies.size());

		Thread.sleep(1000);

		for (Cookie c : cookies) {

			System.out.print("Name: " + c.getName());

			System.out.println(" Value: " + c.getValue());
		}

//		 Name: session-id-time
//		 Value: 2082787201l

//		 Cookie nameCookie = driver.manage().getCookieNamed("session-id-time");
//		 // session-id-time=2082787201l; expires=Sun, 20 Feb 2022 09:36:23 CST; path=/; domain=.amazon.com
//		 System.out.println(nameCookie.getValue());

		Thread.sleep(1000);

		Cookie cookObj = new Cookie("Jack's cookie", "12345");
		driver.manage().addCookie(cookObj);

		cookies = driver.manage().getCookies();
		System.out.println("number of cookies = " + cookies.size());

		for (Cookie c : cookies) {

			System.out.print("Name: " + c.getName());

			System.out.println(" Value: " + c.getValue());
		}
		
		Thread.sleep(1000);
		
		driver.manage().deleteAllCookies(); 
		
		cookies = driver.manage().getCookies();
		
		System.out.println("number of cookies last = " + cookies.size()); 

		driver.quit();

	}

}
