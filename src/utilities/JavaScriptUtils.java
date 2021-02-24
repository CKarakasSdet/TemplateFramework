package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

	public static void flash(WebElement element, WebDriver driver) {
		// JavascriptExecutor js = (JavascriptExecutor) driver ;

		String bgColor = element.getCssValue("backgroundColor");

		for (int i = 0; i < 5; i++) {
			changeColor("#000000", element, driver);
			changeColor(bgColor, element, driver);
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].style.border='8px solid red '", element);
	}

	public static String getTitleByJavascript(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString(); 		
		return title ;

	}
	
	public static void clickElementByJavascript(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element); 
	}
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+ message +"');"); 
	}
	
	public static void refreshByJavascript(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0);"); 
	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void scrollToBottomOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	

	
	

}
