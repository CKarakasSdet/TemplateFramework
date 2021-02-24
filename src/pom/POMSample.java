package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

public class POMSample {
	
	WebDriver driver ;
	
	
	@FindBy(name="name")
	WebElement element ;
	
	
	public POMSample(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
	}

}
