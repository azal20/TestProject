package seleniumwebdriver_Tuts_Naveen2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_MultiSelector_Field1 {
	
	public static WebDriver driver;

	//@Test
	public void openBrowser()
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumAllFiles\\chromedriver.exe");
		driver =  new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		//List<WebElement> ddLanguages = driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete ui-front ui-menu')]//li//a"));
		//List<WebElement> ddLanguages = driver.findElements(By.xpath("//li[@class='ng-scope']//a"));
		//List<WebElement> ddLanguages = driver.findElements(By.xpath("//li[@class='ng-scope']//a[contains(@class,'ui-corner-all')]"));
		List<WebElement> ddLanguages = driver.findElements(By.xpath("//a[contains(@class,'ui-corner-all')]"));
		System.out.println(ddLanguages.size());
		
		//Print all the values in 'Languages' multiselector drop-down field
		for(int i=0; i > ddLanguages.size(); i++)
		{
			String langValues = ddLanguages.get(i).getText();
			//String langValues = driver.findElements(By.xpath("//li[@class='ng-scope']//a")).get(i).getText();
			//String langValues = driver.findElements(By.xpath("//li[@class='ng-scope']//a[contains(@class,'ui-corner-all')]")).get(i).getText();
			//String langValues = driver.findElements(By.xpath("//a[contains(@class,'ui-corner-all')]")).get(i).getText();
			System.out.println(langValues);
			
		}
		
		
	
	}
	
	
	public static void main(String[] args)
	{
		Handle_MultiSelector_Field1 obj = new Handle_MultiSelector_Field1();
		obj.openBrowser();
		
	}

}
