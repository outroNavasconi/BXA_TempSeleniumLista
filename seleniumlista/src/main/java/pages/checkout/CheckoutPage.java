package pages.checkout;

import framework.execute.Execute;

public class CheckoutPage extends CheckoutObject {
	private final Execute execute;
	
	public CheckoutPage() {
		this.execute = new Execute();
	}
	
	public void proceedWithCheckout(String firstName, String lastName, String postalCode) {
		this.execute.write(super.firstName, firstName);
		this.execute.write(super.lastName, lastName);
		this.execute.write(super.postalCode, postalCode);
		this.execute.click(super.btnContinue);
	}
	
	public void finishCheckout() {
		this.execute.click(super.finish);
	}
	
	public String getFinalMessage() {
		return this.execute.getTextElement(super.messageHeader);
	}
	
	public double getItemSubtotal() {
		return Double.parseDouble(this.execute.getTextElement(super.itemSubtotal).replace("Item total: $", ""));
	}
}
