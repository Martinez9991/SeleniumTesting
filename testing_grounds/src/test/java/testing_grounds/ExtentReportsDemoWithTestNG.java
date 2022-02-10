package testing_grounds;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemoWithTestNG {
	
	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	
	WebDriver driver= null;
	
	//before or after suite are for multiple tests cases 
	@BeforeSuite
	public void setUp() 
	{
		sparkReporter = new ExtentSparkReporter("Spark2.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void setUpTest() 
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() throws Exception
	{
		ExtentTest test = extent.createTest("My first test","Sample Description");		
		driver.get("https://www.google.com/");
		test.pass("Navigated to google.com");
		test.log(Status.INFO,"This step shows usage of log(status ,details)");
		test.info("This step shows usage of info(details)");
		test.fail("test", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@Test
	public void test2() throws Exception
	{
		ExtentTest test = extent.createTest("My first test","Sample Description");		
		test.log(Status.INFO,"This step shows usage of log(status ,details)");
		test.info("This step shows usage of info(details)");
		test.pass("test", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterTest
	public void tearDownTest()
	{
		driver.close();
		driver.quit();
		System.out.print("Test Completed Successfully");
	}
	
	@AfterSuite
	public void tearDown() 
	{
		extent.flush();
	}

}
