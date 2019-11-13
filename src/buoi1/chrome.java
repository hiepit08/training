package buoi1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class chrome {
 
  @BeforeClass
  public void beforeClass() {
	  WebDriver driver;
	  System.setProperty("webdriver.chrome.driver", "D:\\setup\\chromedriver.exe");
  driver =new ChromeDriver();
	  driver.get("https://www.google.com/search?q=google&rlz=1C1GCEU_viVN873VN873&oq=go&aqs=chrome.1.69i57j0l4j69i60.2624j0j7&sourceid=chrome&ie=UTF-8");
  }
  @Test
  public void f() {
	  System.out.print("hiepPT");
	  
  }
  @AfterClass
  public void afterClass() {
  }

}
