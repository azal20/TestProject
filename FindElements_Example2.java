package seleniumwebdriver_Tuts_Naveen2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindElements_Example2 {
	
	
	public static WebDriver driver;
	
public static JavascriptExecutor js;
	
	@Test
	public void openBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumAllFiles\\chromedriver.exe");
		driver =  new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Register.html");

		
		//Find Elements
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(list.size());
		
		//Print the list of Items
		for(int i=0; i < list.size(); i++)
		{
			String listValues= driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).getAttribute("value");
			System.out.println(listValues);
			
			//.... Trying to select all check-boxes fields
			//driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();
			
			//...Trying to click check-box showing @ specific number/index
			//driver.findElements(By.xpath("//input[@type='checkbox']")).get(2).click();
			
			
			//Searching & than clicking desired check-box field control
			if(listValues.equals("Movies"))
			{
				list.get(i).click();				
				break;
			}
		}
		
		
		
		System.out.println();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
	}

}
