package pages.components.menu;

import framework.execute.Execute;

public class MenuPage extends MenuObject {
	private final Execute execute;
	
	public MenuPage() {
		this.execute = new Execute();
	}
	
	public void accessCart() {
		this.execute.click(super.cart);
	}
	
	public void resetAppState() {
		this.execute.click(super.menu);
		this.execute.click(super.resetAppState);
	}
}
