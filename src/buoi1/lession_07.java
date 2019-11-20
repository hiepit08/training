package buoi1;

import static org.testng.AssertJUnit.assertArrayEquals;
import static org.testng.AssertJUnit.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class lession_07 {
	ChromeDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "D:\\setup\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void TC_01() {
		// Click my account
		driver.get("http://live.demoguru99.com/");
		WebElement myAcc = driver.findElement(
				By.xpath("//a[text()='Orders and Returns']/parent::li/preceding-sibling::li[@class='first']/a"));
		myAcc.click();
		// kiem tra link url
		System.out.print(driver.getCurrentUrl());
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://live.demoguru99.com/index.php/customer/account/login/");

//Click create account
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement createAcc = driver.findElement(By.xpath("//span[text()='Create an Account']"));
		js.executeScript("arguments[0].click();", createAcc);
	}

@Test
	public void TC_02() throws InterruptedException {
		driver.get("https://demos.telerik.com/kendo-ui/styling/checkboxes");
		// chưa click thì click để chọn
		WebElement dual = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']"));
		if (dual.isDisplayed() && !dual.isSelected()) {
			dual.click();
			Thread.sleep(7000);
		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", dual);
			Thread.sleep(7000);
		}
		Assert.assertTrue(dual.isSelected());

	}
@Test
public void TC_03() throws InterruptedException  {
	driver.get("https://demos.telerik.com/kendo-ui/styling/radios");
	WebElement dual = driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']"));
	if (dual.isDisplayed() && !dual.isSelected()) {
		dual.click();
		Thread.sleep(7000);
	} else {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dual);
		Thread.sleep(7000);
	}

}
@Test
public void TC_04()  {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement createAcc = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
	createAcc.click();

	Alert mesageTo= driver.switchTo().alert();
	mesageTo.accept();


	WebElement message = driver.findElement(By.xpath("//p[text()='You clicked an alert successfully ']"));
	js.executeScript("arguments[0].scrollIntoView(true);", message);
	Assert.assertEquals(message.getText(), "You clicked an alert successfully ");
}

@Test
public void TC_05() throws InterruptedException  {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	WebElement createAcc = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
	createAcc.click();

	Alert mesageTo= driver.switchTo().alert();
	mesageTo.dismiss();


	WebElement message = driver.findElement(By.xpath("//p[text()='You clicked: Cancel']"));
	Assert.assertEquals(message.getText(), "You clicked: Cancel");
}

@Test
public void TC_06() throws InterruptedException  {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement createAcc = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
	createAcc.click();

	Alert mesageTo= driver.switchTo().alert();
	mesageTo.sendKeys("hiepit08");
	mesageTo.accept();


	WebElement message = driver.findElement(By.xpath("//p[text()='You entered: hiepit08']"));
	js.executeScript("arguments[0].scrollIntoView(true);", message);
	Assert.assertEquals(message.getText(), "You entered: hiepit08");
}
	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
