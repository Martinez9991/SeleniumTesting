package testing_grounds;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.GoogleSearchPage;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class TestNG_Demo {

	private static WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() 
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public static void googleSearch() 
	{

		driver.get("https://www.google.com/");

		GoogleSearchPage.buttoncookie_accept(driver).sendKeys(Keys.RETURN);
		
		GoogleSearchPage.textbox_search(driver).sendKeys("BSB Bright&Smart Ideas");
		
		GoogleSearchPage.button_search(driver).submit();
	
	}
	
	@AfterTest
	public void tearDownTest()
	{
		driver.close();
		driver.quit();
		System.out.print("Test Completed Successfully");
	}
	
}
