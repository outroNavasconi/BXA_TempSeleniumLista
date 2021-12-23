package pages.login;

import org.openqa.selenium.By;

class LoginObject {
	protected final By password = By.id("password");
	protected final By username = By.id("user-name");
	protected final By login = By.id("login-button");
	protected final String url = "https://www.saucedemo.com/";
	protected final By errorMessage = By.xpath("//div[@id='login_button_container']//h3");
}
