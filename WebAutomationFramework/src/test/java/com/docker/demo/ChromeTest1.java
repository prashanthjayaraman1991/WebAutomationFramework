package com.docker.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest1 {

	@Test
	public void test1() throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = DesiredCapabilities.chrome();

		URL url = new URL("http://mydocker.com:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, dc);

		driver.get("http://mydocker.com:4444/wd/hub");
		Thread.sleep(2000);
		System.out.println("Current url is: " + driver.getTitle()+" in test 1 Chrome");

		driver.quit();
	}
}
