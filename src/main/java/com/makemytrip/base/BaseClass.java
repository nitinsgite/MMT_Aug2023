package com.makemytrip.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	private final String URL = "https://www.makemytrip.com/";
	private static final String RESOURCESPATH = System.getProperty("user.dir");

	@BeforeSuite
	public void reportSetup() {
		extentReport = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(RESOURCESPATH + "/reports/Results.html");
		extentReport.attachReporter(spark);
		spark.config().setDocumentTitle("MMT Execution Result");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("MMT Execution Report");
	}
	
	@BeforeMethod
	public void setup() {
		// use CH Driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(URL);
		
	}

	@AfterMethod
	public void quit() {
		driver.close();
		driver.quit();
	}
	
	@AfterSuite
	public void flush() {
		extentReport.flush();
	}
	
}
