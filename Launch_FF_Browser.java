package seleniumwebdriver_Tuts_Naveen2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Launch_FF_Browser {
	
	public static WebDriver driver;
	
	@Test
	public void openBrowser()
	{
		
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumAllFiles\\FFDriver\\geckodriver.exe");
		driver =new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
	}

}
