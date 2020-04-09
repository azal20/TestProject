package seleniumwebdriver_Tuts_Naveen2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Handle_Frames {
	
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
	
		//Mouse hover to 'SwitchTo' menu
		Actions action =  new Actions(driver);	
		action.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']"))).build().perform();
		
		//When menu get expand than click 'Frames' menu
		driver.findElement(By.xpath("//a[text()='Frames']")).click();
		
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		System.out.println(totalFrames.size());
		
		
		//Switch to frame and enter value in text field
		driver.switchTo().frame("SingleFrame");
		driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5']//input")).sendKeys("Waheed Abbas");
		
		
		
		
		
		
		
		
		
		
	}

}
