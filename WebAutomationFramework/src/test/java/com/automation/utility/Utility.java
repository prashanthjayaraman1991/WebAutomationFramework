package com.automation.utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility {
	public static WebDriver driver;

	/**
	 * sendKeysInCaps using keys.SHIFT to enter text in caps
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendKeysInCaps(WebElement element, String text) {
		element.sendKeys(Keys.SHIFT, text);

	}

	/**
	 * mouseOver and Element
	 */
	public static void mouseOverElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	/**
	 * helps to switch to an alert popup
	 */
	public static void switchToAlert() {
		driver.switchTo().alert();
	}
}
