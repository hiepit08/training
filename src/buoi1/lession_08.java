package buoi1;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.List;
import java.sql.Driver;

import javax.swing.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Move;
import org.testng.annotations.AfterClass;

@Test
public class lession_08 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "D:\\setup\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

@Test
	public void TC_01() {
		driver.get("https://www.myntra.com/");
		// hover chuột vào Discover
		WebElement hover = driver.findElement(By.xpath("//nav[@class='desktop-navbar']//a[text()='Discover']"));
		Actions action = new Actions(driver);
		action.moveToElement(hover).perform();
		// Click chọn 1 page
		action.click();
		WebElement roadster = driver.findElement(By.xpath("//a[text()='Roadster']"));
		action.moveToElement(roadster).click();
	}

/*	 @Test
	public void TC_02() {
	 driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		 //Click And Hold từ 1 đến 4
	List<WebElement> elements =driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));
		 Actions action = new Actions(driver);

	}
*/
 @Test
	public void TC_4() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// Double click vào Double Click Me
		WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double click me']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", doubleClick);
		Actions action = new Actions(driver);
		action.doubleClick(doubleClick).perform();
		// assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(),"Hello
		// Automation Guys!");
	}

	@Test
	public void TC_5() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		// Double click vào Double Click Me
		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(rightClick).perform();
//hover chuot vao Quit
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Quit']"))).perform();

	}
	@Test
	public void TC_6() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");
		// Drag And Drop Element
		WebElement drag = driver.findElement(By.xpath("//div[@id='droptarget']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='draggable']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();


	}

	@AfterClass
	public void afterClass() {
	}

}
