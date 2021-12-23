package tests.checkout;

import org.junit.*;
import base.BaseTest;
import pages.cart.CartPage;
import pages.login.LoginPage;
import static org.junit.Assert.*;
import pages.checkout.CheckoutPage;
import pages.inventory.InventoryPage;
import pages.components.menu.MenuPage;

public class CheckoutTest extends BaseTest {
	private final CartPage cartPage;
	private final MenuPage menuPage;
	private final LoginPage loginPage;
	private final CheckoutPage checkoutPage;
	private final InventoryPage inventoryPage;
	
	public CheckoutTest() {
		super("CheckoutTest");
		this.cartPage = new CartPage();
		this.menuPage = new MenuPage();
		this.loginPage = new LoginPage();
		this.checkoutPage = new CheckoutPage();
		this.inventoryPage = new InventoryPage();
	}
	
	@Test
	public void exercicio09() {
		this.loginPage.accessAccount("standard_user", "secret_sauce");
		assertEquals("PRODUCTS", this.inventoryPage.getTitlePage());
		this.inventoryPage.addItemToCartByOrder(1);
		String itemName = this.inventoryPage.getItemsName().get(0);
		this.menuPage.accessCart();
		double totalValue = this.cartPage.getTotalPrice();
		assertTrue(this.cartPage.getItemsName().contains(itemName));
		this.cartPage.goToCheckout();
		this.checkoutPage.proceedWithCheckout("Ada", "Lovelace", "46383");
		assertTrue(totalValue == this.checkoutPage.getItemSubtotal());
		this.checkoutPage.finishCheckout();
		assertEquals("THANK YOU FOR YOUR ORDER", this.checkoutPage.getFinalMessage());
	}
}
