package buoi1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static org.junit.Assert.assertEquals;

import java.sql.Driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lession_05 {
	WebDriver driver;
	By userID=By.xpath("//input[@name='uid']");
	By pass = By.xpath("//input[@name='password']");
	By login = By.xpath("//input[@name='btnLogin']");
	By newCus = By.xpath("//a[text()='New Customer']");
	By name = By.xpath("//input[@name='name']");
	By gender = By.xpath("//input[@value='m']");
	By dateOfBirth = By.xpath("//input[@id='dob']");
	By address = By.xpath("//textarea[@name='addr']");
	By city = By.xpath("//input[@name='city']");
	By state = By.xpath("//input[@name='state']");
	By pinno = By.xpath("//input[@name='pinno']");
	By mobile = By.xpath("//input[@name='telephoneno']");
	By email = By.xpath("//input[@name='emailid']");
	By passWord = By.xpath("//input[@name='password']");
	By submit = By.xpath("//input[@name='sub']");
	By success = By.xpath("//p[text()='Customer Registered Successfully!!!']");
	By veriName = By.xpath("//td[text()='Customer ID']/following-sibling::td]");
  @Test
  public void TC_01_CreateAccount() {
	  //login user
	  driver.findElement(userID).clear();
	  driver.findElement(userID).sendKeys("mngr233439");
	  driver.findElement(pass).clear();
	  driver.findElement(pass).sendKeys("Ehamyre");
	  driver.findElement(login).click();
	  //clear data
	  driver.findElement(newCus).click();
	  driver.findElement(address).clear();
	  driver.findElement(city).clear();
	  driver.findElement(state).clear();
	  driver.findElement(mobile).clear();
	  driver.findElement(email).clear();
	  driver.findElement(passWord).clear();
	  
	  //Create account
	  driver.findElement(name).sendKeys("AUTOMATION TESTING");
	  driver.findElement(dateOfBirth).sendKeys("01/01/1989");
	  driver.findElement(address).sendKeys("PO Box 911 8331 Duis Avenue");
	  driver.findElement(city).sendKeys("Tampa");
	  driver.findElement(state).sendKeys("FL");
	  driver.findElement(pinno).sendKeys("466250");  
	  driver.findElement(mobile).sendKeys("4555442476");  
	  driver.findElement(email).sendKeys("automation@gmail.com");  
	  driver.findElement(passWord).sendKeys("automation");
	  driver.findElement(submit).click();
	  
	  //Verify Create account
		Assert.assertEquals("Customer Registered Successfully!!!", success);
		Assert.assertEquals("AUTOMATION TESTING",veriName);
		
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "D:\\setup\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://demo.guru99.com/v4/");
  }
  @AfterClass
  public void afterClass() {
  }

}
