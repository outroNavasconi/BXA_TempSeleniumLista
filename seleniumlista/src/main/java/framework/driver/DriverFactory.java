package framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (!DriverFactory.driverExist())
			DriverFactory.driver = DriverFactory.createDriver();
		return DriverFactory.driver;
	}
	
	public static boolean driverExist() {
		return DriverFactory.driver != null;
	}
	
	private static WebDriver createDriver() {
		if (DriverProperties.browser == DriverBrowsers.CHROME)
			return DriverFactory.createChromeDriver();
		return DriverFactory.createInternetExplorerDriver();
	}
	
	private static WebDriver createChromeDriver() {
		if (!DriverProperties.debugMode)
			return new ChromeDriver(new ChromeOptions().addArguments("--headless"));
		return new ChromeDriver();
	}
	
	private static WebDriver createInternetExplorerDriver() {
		return new InternetExplorerDriver();
	}
	
	public static void killDriver() {
		if (DriverProperties.killDriver) {
			if (DriverFactory.driverExist())
				DriverFactory.driver.quit();
			DriverFactory.driver = null;
		}
	}
}
