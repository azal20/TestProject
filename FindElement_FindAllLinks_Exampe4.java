package seleniumwebdriver_Tuts_Naveen2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindElement_FindAllLinks_Exampe4 {
	

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
			
			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			System.out.println(allLinks.size());

			
			//Print all the LINK in website
			for(int i=0; i < allLinks.size(); i++)
			{
				String linkList = allLinks.get(i).getText();
				System.out.println(linkList);
			}

		}

}
