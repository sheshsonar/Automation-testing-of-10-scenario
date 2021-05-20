package PageObjectModel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helper.readexcel;
import jxl.read.biff.BiffException;
import testScript.ReadingProperties;

public class HomePage {
	
	WebDriver driver = null;// WebDriver is assigned to null so it doesn't collect garbage vakue.it is declared in main class so it can be accessed by other methods.
	
	@BeforeMethod
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","C:\\impdontdelete\\chromedriver_win32\\chromedriver.exe");
		 //ChromeDriver driver = new ChromeDriver();
		 driver = new ChromeDriver();
		 driver.get("https://jupiter.cloud.planittesting.com/#/home"); 
	}
	
	
	
		
  @Test(priority = 1) //Assigning the priority to run the test cases.
  public void hmpageveri() throws IOException {
	  
	  JupitorHomePage j1 = new JupitorHomePage(driver);
	  j1.dohomepagevalid(); // calling home page validation method
	  j1.Scnshot(); // Calling method to take screenshot
	  
	  
  }  
  

  
  
  
  @Test(dataProvider = "dp")// Gave the reference of data provider as source.
  public void login(String u , String p) throws IOException, BiffException { 
	  
	  JupitorHomePage j1 = new JupitorHomePage(driver);
	  j1.dologin(u,p);
	 	  
  }
  
  @DataProvider
  public Object[][] dp() throws BiffException, IOException {
	  
	  readexcel rx = new readexcel();
	  int rowcnt = rx.getRowcount(0);
	  //int colcnt = rx.getColcount(0);
	  
	  
	  Object[][] info = new  Object[rowcnt][2]; // Creation of multidimensional array
	  
	  for(int i = 1; i<rowcnt; i++)
	  {
		  
			  info[i][0] = rx.getData(0, 0, i); // usname from excel
			  info[i][1] = rx.getData(0, 1, i); // pass from excel
			  
			  //System.out.println(info[i][0] +" "+  info[i][1]); // used to check if its receiving the data or not.
	
	  }
	  return info; //returning the data
  }
 
    
  @AfterMethod
  public void close()
  {
	  driver.close(); // WebDriver closes the window.
  }
}
