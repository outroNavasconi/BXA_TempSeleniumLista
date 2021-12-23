package framework.execute;

import org.openqa.selenium.By;
import framework.driver.DriverFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

class Wait {
	private final int TIME = 16000;
	
	public Wait() {}
	
	public void waitToBeClickable(By by) {
		this.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public void waitPresenceOfElement(By by) {
		this.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	private WebDriverWait getWebDriverWait() {
		return new WebDriverWait(DriverFactory.getDriver(), this.TIME);
	}
}
