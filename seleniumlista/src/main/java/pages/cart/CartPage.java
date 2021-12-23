package pages.cart;

import java.util.ArrayList;
import framework.execute.Execute;

public class CartPage extends CartObject {
	private final Execute execute;
	
	public CartPage() {
		this.execute = new Execute();
	}
	
	public ArrayList<String> getItemsName() {
		return this.execute.getTextOfElements(super.inventoryItemName);
	}
	
	public void removeItemsFromCart(String... items) {
		for (String item : items) 
			this.execute.clickButtonInsideContainerByText(super.cartItem, super.remove, item);
	}
	
	public double getTotalPrice() {
		double total = 0;
		ArrayList<String> prices = this.execute.getTextOfElements(super.inventoryItemPrice);
		for (String price : prices)
			total += Double.parseDouble(price.replace("$", ""));
		return total;
	}
	
	public void goToCheckout() {
		this.execute.click(super.checkout);
	}
}
