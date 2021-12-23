package pages.components.menu;

import org.openqa.selenium.By;

class MenuObject {
	protected final By menu = By.id("react-burger-menu-btn");
	protected final By resetAppState = By.id("reset_sidebar_link");
	protected final By cart = By.xpath("//a[@class='shopping_cart_link']");
}
