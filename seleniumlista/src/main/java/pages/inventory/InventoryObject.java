package pages.inventory;

import org.openqa.selenium.By;

class InventoryObject {
	protected final By titlePage = By.className("title");
	protected final String sortByLower = "Price (low to high)";
	protected final By inventoryItem = By.className("inventory_item");
	protected final By inventoryItemName = By.className("inventory_item_name");
	protected final By inventoryItemPrice = By.className("inventory_item_price");
	protected final By inventorySortItems = By.className("product_sort_container");
	protected final By addToCart = By.xpath(".//button[contains(text(), 'Add to cart')]");
	protected final By removeFromCart = By.xpath(".//button[contains(text(), 'Remove')]");
}
