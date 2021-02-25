package extentReports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentRepV4 {
	
	ExtentRepV4 sauceLabTest ; 
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now(); 
	
	
	public ExtentHtmlReporter htmlReporter ;
	public ExtentReports extent ;
	public ExtentTest test ; 

		
	
	
	
	WebDriver driver ;//= new ChromeDriver();
	
	@BeforeTest 
	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/extentReport4.html"); 
		htmlReporter.config().setDocumentTitle(""+now);
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK); 
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "MacOS");
		extent.setSystemInfo("TesterName", "Jack");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	@AfterTest
	public void endReport() {
		extent.flush(); 
	}
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://www.saucedemo.com/");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test case failed is " + result.getName()); 
			test.log(Status.FAIL, "Test case failed is " + result.getThrowable()); // to add error/exception in the report 
			
			String screenshotPath = sauceLabTest.getScreenshot(driver, result.getName()); 
			
			test.addScreenCaptureFromPath(screenshotPath);
		} else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test case SKIPPED is " + result.getName()); 
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test case PASSED is " + result.getName());  
		}
		
		driver.quit(); 
	}
	
	@Test()
	public void sauceLabLoginLogoTest() {
		test = extent.createTest("sauceLabLogoTest"); 
		
		test.createNode("Login with node 1"); 
		Assert.assertTrue(true);
		
		test.createNode("Login with node 2"); 
		Assert.assertFalse(true); 
		
		boolean status = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]")).isDisplayed(); 
		Assert.assertTrue(status); 
	}
	
	@Test
	public void sauceLabLoginLogoTestFail() {
		test = extent.createTest("sauceLabLogoTest"); 		
		boolean status = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]")).isDisplayed(); 
		Assert.assertFalse(status); 
	}
	
	@Test
	public void sauceLabLoginTest() throws InterruptedException {
		
		test = extent.createTest("sauceLabLoginTest");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click(); 
		
		String titleExpected = "Swag Labs"; 
		
		String titleActual = driver.getTitle();
		
		//Assert.assertEquals(titleActual, titleExpected);

		SoftAssert sa = new SoftAssert(); 
		sa.assertAll(); 
		
		Thread.sleep(2000);
		
		if (titleExpected.equalsIgnoreCase(titleActual.toLowerCase())) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		
	}
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); 
		TakesScreenshot ts =(TakesScreenshot) driver ;
		File source = ts.getScreenshotAs(OutputType.FILE); 
		
		System.out.println("Path to source: " + source.getPath());
		
		// after execution we can see a folder "FailedTestsScreenshots" under src folder 
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png" ;
		File finalDestination = new File(destination); 
		
		FileUtils.copyFile(source, finalDestination);
		FileUtils.deleteQuietly(source); 
		return destination ;
	}
	
	
	
	
	
	
	

}
