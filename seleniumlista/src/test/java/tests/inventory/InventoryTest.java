package tests.inventory;

import org.junit.*;
import base.BaseTest;
import java.util.ArrayList;
import pages.cart.CartPage;
import pages.login.LoginPage;
import static org.junit.Assert.*;
import pages.inventory.InventoryPage;
import pages.components.menu.MenuPage;

public class InventoryTest extends BaseTest {
	private final MenuPage menuPage;
	private final CartPage cartPage;
	private final LoginPage loginPage;
	private final InventoryPage inventoryPage;
	
	public InventoryTest() {
		super("InventoryTest");
		this.menuPage = new MenuPage();
		this.cartPage = new CartPage();
		this.loginPage = new LoginPage();
		this.inventoryPage = new InventoryPage();
	}
	
	@Test
	public void exercicio03() {
		this.loginPage.accessAccount("standard_user", "secret_sauce");
		this.inventoryPage.orderItemsByLowerPrice();
		boolean isSorted = true;
		ArrayList<Double> prices = this.inventoryPage.getItemsPriceList();
		for (int i = 0; i < prices.size() - 1; i++)
			if (prices.get(i) > prices.get(i + 1))
				isSorted = false;
		assertTrue(isSorted);
	}
	
	@Test
	public void exercicio06() {
		this.loginPage.accessAccount("standard_user", "secret_sauce");
		String productName = this.inventoryPage.getItemsName().get(0);
		this.inventoryPage.addItemsToCart(productName);
		this.inventoryPage.removeItemFromcart(productName);
		this.menuPage.accessCart();
		assertEquals(0, this.cartPage.getItemsName().size());
	}
	
	@Test
	public void exercicio07() {
		this.loginPage.accessAccount("standard_user", "secret_sauce");
		assertTrue(this.inventoryPage.getItemsName().contains("Sauce Labs Backpack"));
	}
}
