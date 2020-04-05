package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * This class is designed for methods: screenshots alerts frames windows Sync
 * issues java script executer
 */
public class Helper {
	

	
	/**
	 * This method is used to capture screenshots
	 * @param driver
	 */
	public static void captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String screenshotName=getCurrentDateTime()+".png";
			FileHandler.copy(src, new File("./Screenshots/"+screenshotName));
			System.out.println("Screenshot Captured with the Name: "+screenshotName);
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot " + e.getMessage());
		}
	}
	
	/**
	 * This method is to return the date and time for capturing screenshots
	 */
	public static String getCurrentDateTime() {
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate).toString();
	}
}
