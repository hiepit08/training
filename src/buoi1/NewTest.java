package buoi1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTest {

  @BeforeClass
  public void beforeClass() {
	  WebDriver driver;
	  System.setProperty("webdriver.gecko.driver", "D:\\setup\\geckodriver.exe");
  driver =new FirefoxDriver();
	  driver.get("https://www.google.com/search?q=google&rlz=1C1GCEU_viVN873VN873&oq=go&aqs=chrome.1.69i57j0l4j69i60.2624j0j7&sourceid=chrome&ie=UTF-8");
  }
  @Test
  public void f() {
	  //Link
	  System.out.print("hiepPT");
	  
	  
  }
  @AfterClass
  public void afterClass() {
  }

}
