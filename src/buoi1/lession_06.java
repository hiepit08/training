package buoi1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertFalse;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class lession_06 {
	ChromeDriver driver;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "D:\\setup\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://automationfc.github.io/basic-form/index.html");
	}

	@Test
	public void TC_01() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		By job = By.xpath("//select[@id='job1']");
		WebElement job01 = driver.findElement(job);
		// job 01 khong ho tro multi-select
		Select select = new Select(job01);
		Assert.assertFalse(select.isMultiple());
		// Chon automation tester
		select.selectByVisibleText("Automation Tester");
		// Chon gia tri manual tester bang phuong thuc selectByValue
		select.selectByValue("manual");
		// Chọn gia tri mobile tester bang selectbyindex
		select.selectByIndex(4);
		// kiem tra dropdow co du 5 gia tri
		int no2 = select.getOptions().size();
		Assert.assertEquals(no2, 5);
	}
	@Test
	public void TC_02_Custom() throws Exception {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		customDropdown("//span[@id='number-button']", "//select[@id='number']", "19");
	}
	public void customDropdown (String parentXpath, String allItemXpath, String expectedValueItem) throws InterruptedException {

		//Khai báo javascript
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// khởi tạo hàm wait của javascript: 
		WebDriverWait waitExplicit = new WebDriverWait(driver, 60);
		
		//Khai báo webElement cua ô dropdown
		WebElement parentDropdown = driver.findElement(By.xpath(parentXpath));

		if (parentDropdown.isDisplayed()) {
			
			// Click của selenium
			parentDropdown.click();
		} else {
			// Click của javascript
			jsExecutor.executeScript("arguments[0].click();", parentDropdown);
		}
// đợi cho tất cả các phần tử hiển 
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
//tạo 1 list webElement để lưu lại Xpath của tất cả element con
		List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
// for 
		for (int i = 0; i < allItems.size(); i++) {
			if (allItems.get(i).getText().equals(expectedValueItem)) {
				//scroll đến element cần click 
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", allItems.get(i));
				Thread.sleep(6000);
				if (allItems.get(i).isDisplayed()) {
					allItems.get(i).click();
				} else {
					jsExecutor.executeScript("arguments[0].click();", allItems.get(i));
				}

				break;
			}
		}
	}
	
	@AfterClass
	public void afterClass() {
	}

}
