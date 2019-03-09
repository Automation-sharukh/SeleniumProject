package Library;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
   public static void CaptureScreenShot(WebDriver driver,String screenshotName)
   {
	      try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			  File source = ts.getScreenshotAs(OutputType.FILE);
			  FileHandler.copy(source, new File("./ScreenShots/"+screenshotName+".png"));
			  System.out.println("Screen Shot Capture....");
		} catch (Exception e) 
	      {
			System.out.println(e.getMessage());
		  } 
   }
}
