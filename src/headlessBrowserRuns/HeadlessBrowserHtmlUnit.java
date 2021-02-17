package headlessBrowserRuns;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessBrowserHtmlUnit {

	public static void main(String[] args) throws Exception {
			
		// for HTML unit driver, we do not need to set properties. 
		
		HtmlUnitDriver driver = new HtmlUnitDriver(); 
		
		driver.get("https://www.saucedemo.com/");
		
		Thread.sleep(1000);
		
		System.out.println("current url = "+driver.getCurrentUrl());
		
		System.out.println("title = " + driver.getTitle());
		
		Thread.sleep(1000);
		
		driver.quit(); 
		
		
		

	}

}
