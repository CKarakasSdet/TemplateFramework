package utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

	public static void verifyEquals(String expectedResult, String actualResult) {
		if (expectedResult.equals(actualResult)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
			System.out.println("Expected result: " + expectedResult);
			System.out.println("Actual result: " + actualResult);
		}
	}

	public static void openPage(String page, WebDriver driver) {
		List<WebElement> listOfExamples = driver.findElements(By.tagName("a"));
		for (WebElement example : listOfExamples) {
			if (example.getText().contains(page)) {
				example.click();
				break;
			}
		}
	}

	public static void verifyIsDisplayed(WebElement element) {

		if (element.isDisplayed()) {
			System.out.println("Passed");
			System.out.println(element.getText() + " is visible.");
		} else {
			System.out.println("Failed.");
			System.out.println(element.getText() + " is NOT visible.");
		}
	}

	public static void clickWithJavaScript(WebElement element) {
		((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
	}

	public static void switchToWindow(String targetWindowTitle) {
		String origin = Driver.getDriver().getWindowHandle();

		for (String handle : Driver.getDriver().getWindowHandles()) {
			Driver.getDriver().switchTo().window(handle);
			if (Driver.getDriver().getTitle().equals(targetWindowTitle)) {
				return;
			}
		}

		Driver.getDriver().switchTo().window(origin);
	}

	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<>();

		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}

		return elemTexts;
	}

	public static WebElement waitForVisibility(WebElement element, int timeToWaitInSeconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSeconds);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitForVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickability(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForStaleElement(WebElement element) {
		int y = 0;

		while (y < 10) {
			try {
				element.isDisplayed();
				break;
			} catch (StaleElementReferenceException st) {
				y++;
				try {
					Thread.sleep(400);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			
			break ;
		}
				
	}
	
	
	public static void waitForPresenceOfElement(By by, long time) {
		new WebDriverWait(Driver.getDriver(), time).until(ExpectedConditions.presenceOfElementLocated(by)); 
	}
	
	

}
