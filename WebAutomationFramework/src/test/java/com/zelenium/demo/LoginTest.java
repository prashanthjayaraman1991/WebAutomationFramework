package com.zelenium.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
	RemoteWebDriver driver;

	// docker images
	// docker pull elgalu/selenium
	// docker pull dosel/zalenium

	/**
	 * 
	 * docker run --rm -ti --name zalenium -p 4444:4444 \ -v
	 * /var/run/docker.sock:/var/run/docker.sock \ -v
	 * /tmp/videos:/home/seluser/videos \ --privileged dosel/zalenium start
	 * 
	 * Offecial Website: https://opensource.zalando.com/zalenium/
	 * 
	 * http://mydocker.com:4444/grid/admin/live
	 * 
	 * http://mydocker.com:4444/dashboard
	 * @param browserName
	 * @throws MalformedURLException
	 */

	@BeforeTest
	@Parameters("browser")
	void setup(String browserName) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();

		if (browserName.toLowerCase() == "chrome") {
			cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		}

		else if (browserName.toLowerCase() == "firefox") {
			cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
		}

		cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		URL url = new URL("http://mydocker.com:4444/wd/hub");
		driver = new RemoteWebDriver(url, cap);

		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	void loginTest() {
		driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		driver.findElement(By.id("Email")).sendKeys("mail2prashanth1991@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Meenakshi@123");

		driver.findElement(By.xpath("//*[@value='Log in']")).click();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Now Logged in ttitle is:" + driver.getTitle());

	}

	@AfterTest
	void teardown() {
		driver.quit();
	}
}
