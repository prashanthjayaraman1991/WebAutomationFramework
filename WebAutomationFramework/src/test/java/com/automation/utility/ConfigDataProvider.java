package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	public ConfigDataProvider() {
		
		File src=new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Error ocuured while loading the Config.properties File." +e.getMessage());
		}
	}

	public String getDataFromConfig(String keyToSearch) {
		return prop.getProperty(keyToSearch);
	}
	
	public String getBrowserName() {
		return prop.getProperty("Browser");
	}
	
	public String getQAURL() {
		return prop.getProperty("qaURL");
	}
}
