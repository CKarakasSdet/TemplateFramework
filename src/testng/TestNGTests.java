package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGTests {

	SoftAssert sa = new SoftAssert(); 
	
	@Test
	public void test1() {
		Assert.assertEquals("s", "k");
	}
	
	

}
