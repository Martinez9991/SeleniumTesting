package testing_grounds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class browser_test {

	public static void main(String[] args) throws InterruptedException 
	{
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://seleniumhq.org");
		driver.get("https://www.google.com/");
		driver.switchTo().frame(0);
		//driver.manage().deleteAllCookies();
		
		WebElement textBox = driver.findElement(By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.ikrT4e.om7nvf:nth-child(3) div.A8SBwf:nth-child(1) div.RNNXgb:nth-child(3) div.SDkEP div.a4bIc > input.gLFyf.gsfi:nth-child(3)"));
		driver.switchTo().parentFrame();
		WebElement button1 = driver.findElement(By.xpath("//*[@id=\"gksS1d\"]/div"));
	
		//button1.click();
		button1.submit();
		textBox.sendKeys("BSB Smart&Bright Ideas");
		//print(driver.get_cookies());
	
		
		Thread.sleep(3000);
		
		driver.close();
		//driver.quit();
	
	}
	
	
}
