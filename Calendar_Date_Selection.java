package seleniumwebdriver_Tuts_Naveen2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Calendar_Date_Selection {
	

public static WebDriver driver;

@Test
public void openBrowser()
{
	
	
	System.setProperty("webdriver.chrome.driver", "C:\\SeleniumAllFiles\\chromedriver.exe");
	driver =  new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	driver.get("http://demo.automationtesting.in/Register.html");
	
	//Mouse hover to "SwitchTo" menu
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//a[text()='Widgets']"))).build().perform();
	
	
	driver.findElement(By.xpath("//a[text()=' Datepicker ']")).click();

	//2-ways to click any element 1st)Mouse hover via action class & click 2nd)Click direct by using webElement
	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(By.id("datepicker1"))).click().perform();
	
	//driver.findElement(By.id("datepicker1")).click());
	
	
	//tbody//tr[1]//td[1]//a
	
	String beforeXpath = "//tbody//tr[";
	String afterXpath = "]//td[";
	
	boolean flag = false;
	
	for(int row=1; row < 6; row++)
	{
		for(int col=1; col<=7; col++)
		{
			//Here we can also use TRY-Catch BLOCK if we want check row <= 6 it happen when months contains 31 days
			String calendarAllDays = driver.findElement(By.xpath(beforeXpath + row + afterXpath + col + "]")).getText();
			System.out.println(calendarAllDays);
			
	
			if(calendarAllDays.equals("20"))
			{
				driver.findElement(By.xpath(beforeXpath + row + afterXpath + col + "]")).click();
				flag = true;
				break;
			}
			
		} //end of inner loop
		
		if(flag)
		{
			break;
		}
	}
	
	
	
	
	
}
}



