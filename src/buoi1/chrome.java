package buoi1;

import org.testng.annotations.Test;

import pageObjects.HomePageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chrome {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
//buoi 1
		System.setProperty("webdriver.chrome.driver", "D:\\setup\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	// buoi 2
	@Test
	public void TC_01_empty() {

		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		String error = driver.findElement(By.xpath("//div[@id=\"advice-required-entry-email\"]")).getText();
		assertEquals("This is a required field.", error);

	}
	@Test
	public void TC_02_incorrectEmail() {
		driver.findElement(By.xpath("//input[@name=\"login[username]\"]")).sendKeys("qwerr123");
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).sendKeys("abc@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		String error = driver.findElement(By.xpath("//div[@id=\"advice-required-entry-email\"]")).getText();
		assertEquals("This is a required field.", error);

	}
	@Test
	public void TC_03_incorrectPass() {
		driver.findElement(By.xpath("//input[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("hiepit08@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).sendKeys("abc");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		String error = driver.findElement(By.xpath("//div[@id=\"advice-validate-password-pass\"]")).getText();
		assertEquals("Please enter 6 or more characters without leading or trailing spaces.", error);

	}

	@AfterClass
	public void afterClass() {
	}

}
