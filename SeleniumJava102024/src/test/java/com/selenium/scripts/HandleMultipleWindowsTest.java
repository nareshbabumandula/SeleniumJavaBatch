package com.selenium.scripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindowsTest {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		
		String mainWindow = driver.getWindowHandle(); // Browser session ID
		System.out.println("Main window session ID is : " +mainWindow);
		driver.findElement(By.linkText("Locate us")).click(); // Clicking on Locate us opens up a new tab
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Tabs session ID's are : " +windows);
		System.out.println("No fo tabs opened are : " +  windows.size());
		
		Iterator<String> iter = windows.iterator();
		
		while (iter.hasNext()) {
			String childwindow = iter.next();
			System.out.println("Child window session ID is : " + childwindow);
			if (!mainWindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
				driver.findElement(By.id("OutletSearch")).sendKeys("Madhapur");
				Thread.sleep(3000);
				driver.close();
			}
		}
				
		Thread.sleep(4000);
		driver.quit();
	}

}
