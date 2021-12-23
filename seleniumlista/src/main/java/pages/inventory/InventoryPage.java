package pages.inventory;

import java.util.ArrayList;
import framework.execute.Execute;

public class InventoryPage extends InventoryObject {
	private final Execute execute;
	
	public InventoryPage() {
		this.execute = new Execute();
	}
	
	public void addItemToCartByOrder(int order) {
		this.addItemsToCart(this.getItemsName().get(order - 1));
	}
	
	public void addAllItemsToCart() {
		ArrayList<String> all = this.getItemsName();
		String[] items = new String[all.size()];
		items = all.toArray(items);
		this.addItemsToCart(items);
	}
	
	public ArrayList<String> getItemsName() {
		return this.execute.getTextOfElements(super.inventoryItemName);
	}
	
	public void addItemsToCart(String... items) {
		for (String item : items)
			this.execute.clickButtonInsideContainerByText(super.inventoryItem, super.addToCart, item);
	}
	
	public void removeItemFromcart(String... items) {
		for (String item : items) 
			this.execute.clickButtonInsideContainerByText(super.inventoryItem, super.removeFromCart, item);
	}
	
	public String getTitlePage() {
		return this.execute.getTextElement(super.titlePage);
	}
	
	public ArrayList<Double> getItemsPriceList() {
		ArrayList<Double> priceValues = new ArrayList<>();
		ArrayList<String> priceTexts = this.execute.getTextOfElements(super.inventoryItemPrice);
		priceTexts.forEach(p -> priceValues.add(Double.parseDouble(p.replace("$", ""))));
		return priceValues;
	}
	
	public void orderItemsByLowerPrice() {
		this.execute.selectOptionInComboByText(super.inventorySortItems, super.sortByLower);
	}
}
