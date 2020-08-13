import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class MonitorSingUp {
	
	private WebDriver driver;
	
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.opera.driver", "/Users/lruiz/eclipse-workspace/Taller_1/src/test/resources/drivers/operadriver");
		
		driver = new OperaDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://localhost:4000/");
	
	}

	
	@Test
	public void test() throws InterruptedException {
		
		//waiting to load
		Thread.sleep(10);
		//go to sing up
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
		
		Thread.sleep(5);

		//fill out form
		driver.findElement(By.name("fullname")).sendKeys("Feliz 28 Galaxy");
		driver.findElement(By.name("username")).sendKeys("WebDriver122");
		driver.findElement(By.name("password")).sendKeys("WebDriver122");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[4]/button")).click();
		
		Thread.sleep(5);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/a")).click();
		
		//welcome
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
		
		//adding new url
		Thread.sleep(5);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/a")).click();
		
		//fill out form with data
		Thread.sleep(5);
		driver.findElement(By.name("title")).sendKeys("Selenium With Java 28");
		driver.findElement(By.name("url")).sendKeys("https://online.galaxy.edu.pe/");
		driver.findElement(By.name("description")).sendKeys("Cursos Online. Prepárate para el futuro. No permitas que el aislamiento social impida tu crecimiento profesional");
	
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/form/div[4]/button")).submit();
		
		Thread.sleep(5);
		
		//go to logout
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
		
	}
	
	
	@After
	public void tearDown() {
		
		//driver.quit();
		
	}
}
