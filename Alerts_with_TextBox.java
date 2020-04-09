package seleniumwebdriver_Tuts_Naveen2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Alerts_with_TextBox {
	
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
		
		//Mouse hover to "SwitchTo" menu
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']"))).build().perform();
		
		driver.findElement(By.xpath("//a[text()='Alerts']")).click();
		
		
		//Upon clicking Alert will appear
		//driver.findElement(By.id("OKTab")).click();
		driver.findElement(By.xpath("//div[@id='OKTab']")).click();
		
		//Switch to alert
		Alert alert  = driver.switchTo().alert();
		System.out.println("Alert text: " + alert.getText());       //Print alert text
		alert.accept();  						   //click OK/YES button
		

		
		System.out.println();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
	}

}
