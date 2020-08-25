package com.docker.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FirefoxTest1 {
	@Test
	public void test4() throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = DesiredCapabilities.firefox();

		URL url = new URL("http://192.168.99.100:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, dc);
		driver.manage().window().maximize();
		driver.get("https://google.com");
		Thread.sleep(5000);
		System.out.println("Current url is: " + driver.getTitle()+" in test 4 Firefox");

		driver.quit();
	}
}
