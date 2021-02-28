package utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	
	private static final Logger logger = LogManager.getLogger("");
	
	
	public BasePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	

}
