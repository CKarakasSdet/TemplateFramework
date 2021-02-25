package listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test()
	void loginByEmail() {
		System.out.println("Login by email."); 
		Assert.assertEquals("jack", "jack"); // true 
	}
	
	@Test
	void loginByFacebook() {
		System.out.println("Login by Facebook."); 
		Assert.assertEquals("jack", "karakas"); // false  
	}
	

}


