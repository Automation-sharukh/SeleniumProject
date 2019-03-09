package CaptureScreentshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import Library.Utility;

public class ScreenShot
{
	@Test
   public void ScreenShot() throws Exception
   {
	  String ProjectPath = System.getProperty("user.dir");
	  System.setProperty("webdriver.chrome.driver", ProjectPath+"/drivers/ChromeDriver/chromedriver.exe");
	  WebDriver driver = new ChromeDriver(); 
	  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	  
	  driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Automation");
	  
	  Utility.CaptureScreenShot(driver,"Enter username");
	  
	  driver.quit();
   }
}

