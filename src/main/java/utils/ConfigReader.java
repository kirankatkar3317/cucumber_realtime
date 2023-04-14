package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	
	public Properties initializeProp() throws IOException {
		Properties prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		try{
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		
		return prop;
			
	}

	
	
	
	
	
	
	
}
