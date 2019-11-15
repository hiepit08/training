package buoi1;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lession_03{
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

	// @Test
	public void TC_02_incorrectEmail() {
		driver.findElement(By.xpath("//input[@name=\"login[username]\"]")).sendKeys("qwerr123");
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).sendKeys("abc@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		String error = driver.findElement(By.xpath("//div[@id=\"advice-required-entry-email\"]")).getText();
		assertEquals("This is a required field.", error);

	}

//	@Test
	public void TC_03_incorrectPass() {
		driver.findElement(By.xpath("//input[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("hiepit08@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).sendKeys("abc");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		String error = driver.findElement(By.xpath("//div[@id=\"advice-validate-password-pass\"]")).getText();
		assertEquals("Please enter 6 or more characters without leading or trailing spaces.", error);
	}

	// buoi 3
	//@Test
	public void TC_04_incorrectPass123123() {
		driver.findElement(By.xpath("//input[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("hiepit08@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).sendKeys("123123123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		String error = driver.findElement(By.xpath("//p[text()='* Required Fields']")).getText();
		assertEquals("* Required Fields", error);
		String error2=driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText();
		assertEquals("Invalid login or password.", error2);
	}
	@Test
	public void TC_05_correctAccount() {
		driver.findElement(By.xpath("//input[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("hiepit08@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"login[password]\"]")).sendKeys("123456789");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		String message = driver.findElement(By.xpath("//div[@class=\"box-content\"]//p[contains(text(),'hiep Thi Phan')]")).getText().trim();
		assertEquals("hiep Thi Phan\n" + 
				"hiepit08@gmail.com\n" + 
				"Change Password", message);
	}

	@Test
	public void TC_06_Register() {
	driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
	driver.findElement(By.xpath("//input[@id=\"firstname\"]")).sendKeys("Nguyen");	
	driver.findElement(By.xpath("//input[@id=\"middlename\"]")).sendKeys("Van");
	driver.findElement(By.xpath("//input[@id=\"lastname\"]")).sendKeys("A");
	driver.findElement(By.xpath("//input[@id=\"email_address\"]")).sendKeys("Hiep"+randomEmail()+"@gmail.com");
	driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//input[@id=\"confirmation\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//input[@id=\"is_subscribed\"]")).click();
	driver.findElement(By.xpath("//span[text()='Register']")).click();
	String message =driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText();
	assertEquals("Thank you for registering with Main Website Store.",message);
	driver.findElement(By.xpath("//a[@class=\"skip-link skip-account skip-active\"]//span[text()='Account']")).click();
	driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	}
	
	public int randomEmail() {
		Random email=new Random();
		int randomEmail= email.nextInt(800);
		return randomEmail;
	}

	@AfterClass
	public void afterClass() {
	}
}