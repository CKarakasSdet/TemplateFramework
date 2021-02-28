package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	@SuppressWarnings("null")
	public static void captureScreenshot() throws IOException {
		
		WebDriver driver = null ;

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File target = new File(".//Screenshots/twoplugs.png");

		FileUtils.copyFile(src, target);

		FileUtils.deleteQuietly(src);
	}

}
