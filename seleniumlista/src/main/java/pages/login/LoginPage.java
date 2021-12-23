package pages.login;

import framework.execute.Execute;

public class LoginPage extends LoginObject {
	private final Execute execute;
	
	public LoginPage() {
		this.execute = new Execute();
	}
	
	public void goToInitialPage() {
		this.execute.goToPage(super.url);
	}
	
	public void accessAccount(String username, String password) {
		this.execute.write(super.username, username);
		this.execute.write(super.password, password);
		this.execute.click(super.login);
	}
	
	public String getErrorMessage() {
		return this.execute.getTextElement(super.errorMessage);
	}
}
