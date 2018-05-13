package seleniumgrid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GridExampleTest {

	public RemoteWebDriver driver;
	public static String appURL = "http://www.google.com";
	
	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL("http://192.168.43.119:42653/wd/hub"), capabilities);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		System.out.println("Testing");
	}
	
	@Test
	public void testGooglePageTitleInIEBrowser() throws InterruptedException {
		System.out.println("*** Navigation to Application ***");
		driver.navigate().to(appURL);
		Thread.sleep(10000);
		String strPageTitle = driver.getTitle();
		System.out.println("*** Verifying page title ***");
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}
	
	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

}
