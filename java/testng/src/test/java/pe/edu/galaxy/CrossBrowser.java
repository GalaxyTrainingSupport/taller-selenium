package pe.edu.galaxy;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class CrossBrowser {

	WebDriver driver;
	JSONObject jsonObject;
	
	String baseUrl = "http://localhost:4000/";
	
	@BeforeMethod
	public void loadData() {
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("/Users/lruiz/eclipse-workspace/Taller_2/src/test/resources/sources/login.json"));
			jsonObject = (JSONObject) obj;

		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
	}
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/lruiz/eclipse-workspace/Taller_2/src/test/resources/drivers/geckodriver");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/lruiz/eclipse-workspace/Taller_2/src/test/resources/drivers/chromedriver");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver",
					"/Users/lruiz/eclipse-workspace/Taller_2/src/test/resources/drivers/operadriver");
			driver = new OperaDriver();
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void loadWebPage() {
		driver.get(baseUrl);
	}

	@Test(priority = 2)
	public void goToSingIn() {

		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[1]/a")).click();

	}

	@Test(priority = 3)
	public void setCredential() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys((String) jsonObject.get("Username"));
		driver.findElement(By.name("password")).sendKeys((String) jsonObject.get("Password"));
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/button")).submit();

	}
	
	@AfterTest
	public void afterClass() {

		driver.quit();

	}
	
}