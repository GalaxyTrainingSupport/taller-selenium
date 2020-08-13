package pe.edu.galaxy;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Monitor {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver",
				"/Users/lruiz/eclipse-workspace/Taller_2/src/test/resources/drivers/geckodriver");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("http://localhost:4000/");

	}

	@Test(priority = 1)
	public void goToSingIn() {
		//go to link sing in
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[1]/a")).click();

	}

	@Test(priority = 2)
	public void setCredential() throws InterruptedException {
		// put credentials
		driver.findElement(By.name("username")).sendKeys("WebDriver122");
		driver.findElement(By.name("password")).sendKeys("WebDriver122");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/button")).submit();
	
		Thread.sleep(5000);
		
        Assert.assertEquals("WebDriver122", driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h5")).getText());
        
	}
	
	@Test(priority = 3)
	public void logout() {
		driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[3]/a")).click();
	}
	
	@Test(priority = 4)
	public void failLogin() throws InterruptedException {
		// put credentials
		driver.findElement(By.name("username")).sendKeys("galaxy");
		driver.findElement(By.name("password")).sendKeys("sele22");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/button")).submit();
		
		String expectedMessage = "The Username does not exists.";
		String actualMessage = driver.findElement(By.xpath("/html/body/div[1]/div/div/div")).getText();
		
		Thread.sleep(5000);
		
		Assert.assertEquals(expectedMessage, actualMessage, "Invalid Username");
		
	}

	@AfterClass
	public void afterClass() {

		//driver.quit();

	}

}
