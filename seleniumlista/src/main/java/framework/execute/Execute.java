package framework.execute;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import framework.driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Execute {
	private Wait wait;

	public Execute() {
		this.wait = new Wait();
	}
	
	public void goToPage(String url) {
		DriverFactory.getDriver().navigate().to(url);
	}
	
	public void write(By by, String text) {
		this.wait.waitPresenceOfElement(by);
		this.clearField(by);
		this.getElement(by).sendKeys(text);
	}
	
	public void clearField(By by) {
		this.getElement(by).clear();
	}
	
	public void click(By by) {
		this.wait.waitToBeClickable(by);
		this.getElement(by).click();
	}
	
	public void clickButtonInsideContainerByText(By container, By button, String text) {
		List<WebElement> list = DriverFactory.getDriver().findElements(container);
		for (WebElement element : list)
			if (element.getText().contains(text))
				button.findElement(element).click();
	}
	
	public ArrayList<String> getTextOfElements(By by) {
		ArrayList<String> texts = new ArrayList<>();
		List<WebElement> list = DriverFactory.getDriver().findElements(by);
		list.forEach(e -> texts.add(e.getText()));
		return texts;
	}
	
	public void selectOptionInComboByText(By by, String text) {
		this.getSelect(by).selectByVisibleText(text);
	}
	
	public Select getSelect(By by) {
		return new Select(this.getElement(by));
	}
	
	public String getTextElement(By by) {
		return this.getElement(by).getText();
	}
	
	public WebElement getElement(By by) {
		return DriverFactory.getDriver().findElement(by);
	}
}
