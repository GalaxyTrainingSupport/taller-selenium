package pe.edu.galaxy;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReport {

	@Test
	public void loginTest() throws IOException {
	
	System.out.println("Login to Wallet");

	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/myreport_3.html");

	ExtentReports extend = new ExtentReports();
	
	extend.attachReporter(reporter);
	
	ExtentTest logger =  extend.createTest("Login");
	
	logger.log(Status.INFO, "Login to Wallet");
	
	logger.log(Status.PASS, "Title verify");
	
	extend.flush();
	
	
	ExtentTest logger2 =  extend.createTest("Logout");

	logger2.log(Status.FAIL, "Title verify");
	
	//logger2.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	 
	logger2.addScreenCaptureFromPath("/Users/lruiz/eclipse-workspace/Taller_3/screen/404-Error.png");
	
	extend.flush();
	
	}
}
