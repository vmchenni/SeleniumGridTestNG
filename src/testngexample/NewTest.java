package testngexample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	
 WebDriver driver;
 String sURL="https:///www.rediff.com";
  @Test
  public void f() throws InterruptedException {
	  System.out.println("inside foo");
	  driver.get(sURL);
	  Thread.sleep(10000);
	  System.out.println("Page title is"+driver.getTitle());
	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Study\\Files-02-Drivers\\chromedriver.exe"); 
	  driver=new ChromeDriver();
	  
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside after class");
	  driver.close();
	  driver.quit();
  }

}
