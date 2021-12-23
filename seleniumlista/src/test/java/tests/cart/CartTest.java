package tests.cart;

import org.junit.*;
import base.BaseTest;
import pages.cart.CartPage;
import pages.login.LoginPage;
import static org.junit.Assert.*;
import pages.inventory.InventoryPage;
import pages.components.menu.MenuPage;

public class CartTest extends BaseTest {
	private final MenuPage menuPage;
	private final CartPage cartPage;
	private final LoginPage loginPage;
	private final InventoryPage inventoryPage;
	
	public CartTest() {
		super("CartTest");
		this.menuPage = new MenuPage();
		this.cartPage = new CartPage();
		this.loginPage = new LoginPage();
		this.inventoryPage = new InventoryPage();
	}
	
	@Test
	public void exercicio02() {
		this.loginPage.accessAccount("standard_user", "secret_sauce");
		this.inventoryPage.addItemsToCart("Sauce Labs Backpack");
		this.menuPage.accessCart();
		assertTrue(this.cartPage.getItemsName().contains("Sauce Labs Backpack"));
	}	
	
	@Test
	public void exercicio04() {
		this.loginPage.accessAccount("standard_user", "secret_sauce");
		String itemName = this.inventoryPage.getItemsName().get(2);
		this.inventoryPage.addItemToCartByOrder(3);
		this.menuPage.accessCart();		
		assertTrue(this.cartPage.getItemsName().contains(itemName));
		this.cartPage.removeItemsFromCart(itemName);
		assertFalse(this.cartPage.getItemsName().contains(itemName));
	}
	
	@Test
	public void exercicio05() {
		this.loginPage.accessAccount("standard_user", "secret_sauce");
		int items = this.inventoryPage.getItemsName().size();
		this.inventoryPage.addAllItemsToCart();
		this.menuPage.accessCart();
		assertEquals(items, this.cartPage.getItemsName().size());
	}
	
	@Override
	public void afterMethod() {
		this.menuPage.resetAppState();
	}
}
