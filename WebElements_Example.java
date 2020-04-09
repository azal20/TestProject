package seleniumwebdriver_Tuts_Naveen2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebElements_Example {
	
	
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
		
		
		driver.get("http://echoecho.com/htmlforms10.htm");
		
		
		//Casting "JavascriptExecutor" with driver reference variable
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1100)");
		
		//input[@name='group1']
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='radio' and @name='group1']"));
		System.out.println(list.size());
		
		//Print the  text
		for(int i=0; i < list.size(); i++)
		{
			//String listItems = list.get(i).getText();
			//String listItems = driver.findElements(By.xpath("//input[@name='group1']")).get(2).getText();

			//... In order to click specific radio field in group
			//driver.findElements(By.xpath("//input[@name='group1']")).get(2).click();
			
			//In order to click all the radio field
			//driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			
			
			//...Getting text of all radio fields in group
			String listItems = driver.findElements(By.xpath("//input[@type='radio' and @name='group1']")).get(i).getAttribute("value");
			System.out.println(listItems);
			
			//String listItems1 = driver.findElements(By.xpath("//input[@type='radio' and @name='group1']")).get(i).getText();
		//	System.out.println(listItems1);
		
			
			//Trying to click specific radio field option
			if(listItems.equals("Milk"))
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
