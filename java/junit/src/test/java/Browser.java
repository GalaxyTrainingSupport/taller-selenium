import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {
	
	private WebDriver driver;
	
	@Before
	public void setUP() {

		System.setProperty("webdriver.chrome.driver", "/Users/lruiz/eclipse-workspace/Taller_1/src/test/resources/drivers/chromedriver");
		
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
	
		driver.manage().deleteAllCookies();

		
		driver.get("https://www.google.com.pe/");
	}

	@Test
	public void testGalaxyTraining() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.clear();
		
		searchbox.sendKeys("Galaxy Training");
		
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Galaxy Training - Buscar con Google", driver.getTitle());
		
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}
}
