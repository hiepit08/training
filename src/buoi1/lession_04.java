package buoi1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.junit.Assert;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class lession_04 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "D:\\setup\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://automationfc.github.io/basic-form/index.html");
	}

	// lession 04
 //@Test
	public void TC_01_Lession() {
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Email:']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Age:']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Education:']")).isDisplayed());
		driver.findElement(By.xpath("//input[@id=\"mail\"]")).sendKeys("hiepit08@gmail");
		driver.findElement(By.xpath("//textarea[@id=\"edu\"]")).sendKeys("ute");
		driver.findElement(By.xpath("//input[@id=\"under_18\"]")).click();

	}

	//@Test
  public void TC_02_Lession() {
	  
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Email:']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Age:']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Education:']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Job Role 01:']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Interests:']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Slider 01:']")).isEnabled());
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id=\"password\"]")).isEnabled());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id=\"radio-disabled\"]")).isEnabled());
		Assert.assertFalse(driver.findElement(By.xpath("//textarea[@id=\"bio\"]")).isEnabled());
		Assert.assertFalse(driver.findElement(By.xpath("//select[@id=\"job2\"]")).isEnabled());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id=\"check-disbaled\"]")).isEnabled());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id=\"slider-2\"]")).isEnabled());	
}
	//@Test
	 public void TC_03_Lession() {
			driver.get("https://automationfc.github.io/basic-form/index.html");
			driver.findElement(By.xpath("//input[@id=\"under_18\"]")).click();
			driver.findElement(By.xpath("//label[text()='Development']")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//input[@id=\"under_18\"]")).isSelected());
			Assert.assertTrue(driver.findElement(By.xpath("label[text()='Development']")).isSelected());
			driver.findElement(By.xpath("//label[text()='Development']")).click();
			Assert.assertFalse(driver.findElement(By.xpath("label[text()='Development']")).isSelected());
			
	 }
	
	@AfterClass
	public void afterClass() {
	}

}
