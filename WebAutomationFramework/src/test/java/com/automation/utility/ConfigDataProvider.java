package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;

	/**
	 * CnfigDataProvider() - sets the path of the Configuration file
	 */
	public ConfigDataProvider() {

		File src = new File(System.getProperty("user.dir") + "/Config/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Error ocuured while loading the Config.properties File." + e.getMessage());
		}
	}

	/**
	 * This method returns the value for the key passed firstName=John firstName is
	 * the key to search which should be sent as parameter John is the value that
	 * will be sent back as a string all values are String Values from properties
	 * file
	 * 
	 * @param keyToSearch
	 * @return
	 */
	public String getDataFromConfig(String keyToSearch) {
		return prop.getProperty(keyToSearch);
	}

	/**
	 * returns the browser name set in the Config.properties file
	 * 
	 * @return
	 */
	public String getBrowserName() {
		return prop.getProperty("Browser");
	}

	/**
	 * returns the URL set in the Config.properties file
	 * 
	 * @return
	 */
	public String getQAURL() {
		return prop.getProperty("qaURL");
	}
}
