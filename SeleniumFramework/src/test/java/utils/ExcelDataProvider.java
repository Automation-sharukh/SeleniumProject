package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Library.Utility;
//import config.PropertiesFile;
public class ExcelDataProvider
{
	WebDriver driver = null;
	@BeforeTest
	public void setUpTest()
	{
	String ProjectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver",ProjectPath+"/drivers/ChromeDriver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	
	String actualtitle =driver.getTitle();
	System.out.println("Actual Title of webpage is :"+actualtitle);
	
	if(actualtitle.equals("OrangeHRM"))
	{
		System.out.println("title is verifed....");
	}else
		System.out.println("Web page title is missmatch....");
	
	Utility.CaptureScreenShot(driver, "BrowserStarted");
	
	}
	
	@Test(dataProvider="test1data")
	public void test1(String username, String password) throws Exception
	{
		System.out.println(username+" | "+password);
		
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		Thread.sleep(2000);
		
	}
	@AfterTest
	public void testDown()
	{
		Utility.CaptureScreenShot(driver, "HomePage");
		driver.quit();
	}
	
	
	@DataProvider(name = "test1data")
	public  Object[][] getData()
	{
		String excelPath="C:/Users/Sharukh/Selenium/Project/SeleniumFramework/excel/data.xlsx";
		Object data[][]=testData(excelPath,"Sheet1");
		return data;
	}
	
   public  Object[][] testData(String excelPath,String sheetName)
   {
       ExcelUtils excel = new ExcelUtils(excelPath, sheetName); 
	   
	       int rowCount = excel.getRowCount();
	       int colCount = excel.getColCount();
	       
	       Object data[][]=new Object[rowCount-1][colCount];
	              
	      for(int i=1;i<rowCount;i++)
	      {
	    	  for(int j=0;j<colCount;j++)
	    	  {
	    		  String cellData = excel.getCellDataString(i, j);
	    		//  System.out.print(cellData+" | ");
	    		  
	    		  data[i-1][j]=cellData;
	    		  
	    	  }
	    	 // System.out.println();
	    	  }
	      return data;
   }
}
