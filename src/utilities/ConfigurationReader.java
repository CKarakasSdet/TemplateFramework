package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	private static Properties configFile ;
	
	static {
		
		try {
			String path = ".//configuration.properties"; 
			
			System.out.println(path);
			
			FileInputStream fileInput = new FileInputStream(path); 
			
			configFile = new Properties(); 
			
			configFile.load(fileInput);
			
			fileInput.close();
			
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	
	public static String getProperty(String key) {
		return configFile.getProperty(key); 
	}
	
}
