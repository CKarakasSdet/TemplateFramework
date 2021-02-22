package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {
	
	static WebDriver driver ;
	
	static Actions actions = new Actions(driver); 
	
	public static void actionMouseOver(WebElement element) {
		actions.moveToElement(element).build().perform(); 
	}
	
	public static void actionRightClick(WebElement element) {
		actions.contextClick(element).build().perform(); 
	}
	
	
	public static void actionDragAndDrop(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).build().perform(); 
	}
	
	
	public static void actionScrollToPosition(int horizontal_pos, int vertical_pos) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+ horizontal_pos+ "," + vertical_pos +")", "");
	}
	
	public static void actionScrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element); 
	}
	
	public static void actionScrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)" );
	}
	
	
	
	

}
