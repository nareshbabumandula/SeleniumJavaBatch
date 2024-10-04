package com.selenium.scripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.util.PropertyUtil;

public class BrowserTest {
	static WebDriver driver;

	static void browserMethods(String browser) throws InterruptedException, IOException {
		switch (browser.toLowerCase().trim()) {
		case "chrome": case "google": case "CHROME":
			// Launch the chrome browser
			driver = new ChromeDriver();
			break;
		case "edge": case "EDGE":
			// Launch the edge browser
			driver = new EdgeDriver();
			break;
		case "firefox":
			// Launch the firefox browser
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Browser name is invalid..!");
			break;
		}

		// Access website
		driver.get(PropertyUtil.getProperty("app_url"));
		// Maximize the browser window
		driver.manage().window().maximize();
		// Navigate to another URL
		driver.navigate().to(PropertyUtil.getProperty("app_new_url"));
		// Navigate backward
		driver.navigate().back();
		// Navigate backward
		driver.navigate().forward();
		// Refresh the browser window/page
		driver.navigate().refresh();
		// Get the browser title
		System.out.println(driver.getTitle());
		// Get the page current URL
		System.out.println(driver.getCurrentUrl());
		// Get the browser session ID
		System.out.println(driver.getWindowHandle());
		// Get the page html source
		System.out.println(driver.getPageSource());

		Thread.sleep(3000);
		//driver.close(); // closes the browser but not the session
		driver.quit(); // closes all tabs of the browser and also kills the browser session
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		browserMethods("chrome");
	}

}
