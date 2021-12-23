package pages.checkout;

import org.openqa.selenium.By;

class CheckoutObject {
	protected final By finish = By.id("finish");
	protected final By lastName = By.id("last-name");
	protected final By firstName = By.id("first-name");
	protected final By btnContinue = By.id("continue");
	protected final By postalCode = By.id("postal-code");
	protected final By itemSubtotal = By.className("summary_subtotal_label");
	protected final By messageHeader = By.xpath("//div[@id='checkout_complete_container']/h2");
}
