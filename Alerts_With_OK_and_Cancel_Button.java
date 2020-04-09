package seleniumwebdriver_Tuts_Naveen2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Alerts_With_OK_and_Cancel_Button {
	
	public static WebDriver driver;
	
	@Test
	public void openBrowser()
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumAllFiles\\chromedriver.exe");
		driver =  new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		//Mouse hover to "SwitchTo" menu
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']"))).build().perform();
		
		driver.findElement(By.xpath("//a[text()='Alerts']")).click();
		
		//Click button from left menu
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();

		
		//Click button and generate the alert
		//driver.findElement(By.xpath("//div[@id='OKTab']")).click();
		driver.findElement(By.xpath("//button[text()='click the button to display a confirm box ']")).click();
		
		//Switch to alert
		Alert alert = driver.switchTo().alert();		
		
		//Getting alert text
		System.out.println("Alert text: " + alert.getText());
		
		//alert.dismiss();
		alert.accept();
		
		

		
		System.out.println();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
	}

}
