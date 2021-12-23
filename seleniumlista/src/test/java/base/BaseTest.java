package base;

import org.junit.*;
import framework.driver.*;
import java.io.IOException;
import pages.login.LoginPage;
import org.junit.rules.TestName;
import framework.screenshot.Screenshot;

public class BaseTest {
	private final LoginPage loginPage;
	private final Screenshot screenshot;
	private final String evidencesFolder;
	
	@Rule
	public TestName testName = new TestName();
	
	public BaseTest(String evidencesFolder) {
		this.loginPage = new LoginPage();
		this.screenshot = new Screenshot();
		this.evidencesFolder = evidencesFolder;
	}
	
	@Before
	public void before() {
		DriverFactory.getDriver().manage().window().maximize();
		this.beforeMethod();		
		this.loginPage.goToInitialPage();
	}
	
	@After
	public void after() throws IOException {
		this.takeScreenshot();
		this.afterMethod();
		DriverFactory.killDriver();
	}
	
	public void afterMethod() {}
	
	public void beforeMethod() {}
	
	private void takeScreenshot() throws IOException {
		String test = testName.getMethodName().toString();
		this.screenshot.takeScreenshot(this.evidencesFolder, test);
	}
}
