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

public class ContactPage {
	
	WebDriver driver = null;
	
	@BeforeMethod // what should happen before the test is launch.. settinh up environment for test to run.
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","C:\\impdontdelete\\chromedriver_win32\\chromedriver.exe");
		 //ChromeDriver driver = new ChromeDriver();
		 driver = new ChromeDriver();
		 driver.get("https://jupiter.cloud.planittesting.com/#/contact"); 
	}
	
	
	
		 
  @Test(priority = 1) // Validation of the correct conatct page is open ornot.
  public void contpageveri() throws IOException {
	  
	  JupitorContactPage j1 = new JupitorContactPage(driver);
	  j1.doContactpagevalid();
	  
	  JupitorHomePage j2 = new JupitorHomePage(driver);
	  j2.Scnshot();
	  
	  
  }  
  

  
  
  
  @Test(dataProvider = "dp") // Test verifies the feedback form by various inputs from excel sheet
  public void feedbk(String fname,String lname,String eml,String phn,String msg) throws IOException, BiffException, InterruptedException { 
	  
	  JupitorContactPage j1 = new JupitorContactPage(driver);
	  j1.dofeedbck(fname, lname, eml, phn, msg);
	  
	 	  
  }
  
  @DataProvider // feeding the data to feedbk string.
  public Object[][] dp() throws BiffException, IOException {
	  
	  readexcel rx = new readexcel();
	  int rowcnt = rx.getRowcount(1);
	  System.out.println(rowcnt);
	  //int colcnt = rx.getColcount(0);
	  
	  
	  Object[][] info = new  Object[rowcnt][5];
	  
	  for(int i = 1; i<(rowcnt); i++)
	  {
		  
			  info[i][0] = rx.getData(1, 0, i); // fname
			  info[i][1] = rx.getData(1, 1, i); //lname
			  info[i][2] = rx.getData(1, 2, i); //email
			  info[i][3] = rx.getData(1, 3, i); //phone
			  info[i][4] = rx.getData(1, 4, i); // msg
			  					 
		  
	  }
	  return info;
  }
  
  
  @Test // Validation of the back button after feedback is submitted sucessfully.
  public void bcbuttnvalid() throws IOException
  {
	  JupitorContactPage j1 = new JupitorContactPage(driver);
	  j1. bckbtnvalid();
	  
	  JupitorHomePage j2 = new JupitorHomePage(driver);
	  j2.Scnshot();
	  
	 
  }
 
    
  @AfterMethod // After method is used to do the necessery things after the test case is finished.
  public void close() throws IOException
  {
		JupitorHomePage j2 = new JupitorHomePage(driver);
		j2.Scnshot();
		
	  driver.close();
  }
}
