package pages.cart;

import org.openqa.selenium.By;

class CartObject {
	protected final By checkout = By.id("checkout");
	protected final By cartItem = By.className("cart_item");
	protected final By inventoryItemName = By.className("inventory_item_name");
	protected final By inventoryItemPrice = By.className("inventory_item_price");
	protected final By remove = By.xpath(".//button[contains(text(), 'Remove')]");
}
