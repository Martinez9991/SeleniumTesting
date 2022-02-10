package testing_grounds;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.GoogleSearchPage;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTest {

	private static WebDriver driver = null;
	
	public static void main(String[] args)
	{
		googleSearch();
	}
	
	public static void googleSearch() 
	{
		String projectPath = System.getProperty("user.dir");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		GoogleSearchPage.buttoncookie_accept(driver).sendKeys(Keys.RETURN);
		
		GoogleSearchPage.textbox_search(driver).sendKeys("BSB Bright&Smart Ideas");
		
		GoogleSearchPage.button_search(driver).submit();
	
		//Thread.sleep(3000);
		
		driver.close();
		
		System.out.print("Test Completed Successfully");
	}
	
}
