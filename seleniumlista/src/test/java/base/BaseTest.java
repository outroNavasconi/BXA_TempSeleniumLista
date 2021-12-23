package base;

import org.junit.*;
import framework.driver.*;
import java.io.IOException;
import pages.login.LoginPage;
import framework.time.Counter;
import org.junit.rules.TestName;
import framework.screenshot.Screenshot;

public class BaseTest {
	private final LoginPage loginPage;
	private final Screenshot screenshot;
	private final String evidencesFolder;
	private static final Counter counter = new Counter();
	
	@Rule
	public TestName testName = new TestName();
	
	public BaseTest(String evidencesFolder) {
		this.loginPage = new LoginPage();
		this.screenshot = new Screenshot();
		this.evidencesFolder = evidencesFolder;
	}
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		System.out.println("INICIANDO TESTES");
		BaseTest.counter.startCounting("TESTE_CLASSE");
	}
	
	@Before
	public void before() throws Exception {
		BaseTest.counter.startCounting(testName.getMethodName().toString());
		DriverFactory.getDriver().manage().window().maximize();
		this.beforeMethod();		
		this.loginPage.goToInitialPage();
	}
	
	@After
	public void after() throws Exception {
		this.takeScreenshot();
		this.afterMethod();
		BaseTest.counter.stopCounting(testName.getMethodName().toString());
		System.out.println("-- Teste " + testName.getMethodName().toString());
		System.out.println("-- Tempo: " + BaseTest.counter.getFormattedDuration(testName.getMethodName().toString()));
		DriverFactory.killDriver();
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		BaseTest.counter.stopCounting("TESTE_CLASSE");
		System.out.println("TEMPO TOTAL: " + BaseTest.counter.getFormattedDuration("TESTE_CLASSE"));
	}
	
	public void afterMethod() {}
	
	public void beforeMethod() {}
	
	private void takeScreenshot() throws IOException {
		String test = testName.getMethodName().toString();
		this.screenshot.takeScreenshot(this.evidencesFolder, test);
	}
}
