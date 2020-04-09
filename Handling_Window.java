package seleniumwebdriver_Tuts_Naveen2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Handling_Window {
	
public static WebDriver driver;
	
	@Test
	public void openBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumAllFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		

		//Mouse hover to "SwitchTo" menu
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']"))).build().perform();
		
		//Click 'windows' when 'switch-to' menu expands
		driver.findElement(By.xpath("//a[text()='Windows']")).click();
		
		
		//Click button & open new window
		driver.findElement(By.xpath("//button[text()='    click   ']")).click();
		
		//Getting parent & child window
		
		Set<String> totalWindows = driver.getWindowHandles();
		System.out.println(totalWindows.size());
		
		Iterator<String> iterator = totalWindows.iterator();
		String parentWindow  = iterator.next();
		String childWindow = iterator.next();
		
		System.out.println("Parent window: " + parentWindow);
		System.out.println("Child window: " + childWindow);
		
		driver.switchTo().window(childWindow);
		
		System.out.println();
		System.out.println("Child window title: + " + driver.getTitle());
		System.out.println("Child window url: " + driver.getCurrentUrl());
		
	}

}
