package testing_grounds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtendReportsBasicDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		
		ExtentTest test1 = extent.createTest("Googler Search Test one","this is a test to validade google search functionality");
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com/");
		test1.pass("Navigate to google.com");
		
		driver.findElement(By.id("L2AGLb")).click();
		test1.pass("Accepted Cookies");
		driver.findElement(By.name("q")).sendKeys("Victoria2");
		test1.pass("Entered text in Searchbox");
		driver.findElement(By.name("btnK")).submit();
		test1.pass("Pressed keyboard enter key");
		
		driver.close();
		driver.quit();
		test1.pass("Closed the broswer");
		
		test1.info("Test Completed");
		
		extent.flush();
		
	}

}
