package testing_grounds;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObjects;

public class GoogleSerachPageTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) 
	{
		googleSearchTest();
	}

	public static void googleSearchTest() 
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://www.google.com/");
		
		searchPageObj.clickAcceptCookieButton();
		searchPageObj.setTextinSearchBox(" Victoria 2 ");
		searchPageObj.clickSearchButton();
		
		driver.close();
	}
}
