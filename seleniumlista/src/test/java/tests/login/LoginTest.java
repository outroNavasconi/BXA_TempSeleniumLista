package tests.login;

import org.junit.*;
import base.BaseTest;
import pages.login.LoginPage;
import static org.junit.Assert.*;
import pages.inventory.InventoryPage;

public class LoginTest extends BaseTest {
	private final LoginPage loginPage;
	private final InventoryPage inventoryPage;
	
	public LoginTest() {
		super("LoginTest");
		this.loginPage = new LoginPage();
		this.inventoryPage = new InventoryPage();
	}
	
	@Test
	public void exercicio01() {
		this.loginPage.accessAccount("standard_user", "secret_sauce");
		assertEquals("PRODUCTS", this.inventoryPage.getTitlePage());
	}
	
	@Test
	public void exercicio08() {
		this.loginPage.accessAccount("locked_out_user", "secret_sauce");
		assertTrue(this.loginPage.getErrorMessage().contains("Sorry, this user has been locked out."));
	}
}
