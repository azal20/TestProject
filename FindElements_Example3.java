package seleniumwebdriver_Tuts_Naveen2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindElements_Example3 {
	
	public static WebDriver driver;
	
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
			List<WebElement> list = driver.findElements(By.xpath("//input[@type='radio']"));
			System.out.println(list.size());
			
			
			//Print the values
			for(int i=0; i < list.size(); i++)
			{
				
				String listValues = list.get(i).getAttribute("value");
				System.out.println(listValues);
				
				//.... Clicking/selecting all the radio field				
				//list.get(i).click();
				
				//... Clicking specific value
				//list.get(1).click();
				
				//Searching specific values & than clicking
				if(listValues.equals("FeMale"))
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
