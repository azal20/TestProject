package seleniumwebdriver_Tuts_Naveen2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class Launch_IE_Browser {

	public static WebDriver driver;
	
	@Test
	public void openBrowser()
	{
		System.setProperty("webdriver.ie.driver", "C:\\SeleniumAllFiles\\IEDriver\\IEDriverServer.exe");
		driver  = new InternetExplorerDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
	
		
		
		
		
	}
	
	
}
