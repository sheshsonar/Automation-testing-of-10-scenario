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

public class CartPage {
	
	WebDriver driver = null;
	
	@BeforeMethod // what should happen before the test is launch.. settinh up environment for test to run.
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","C:\\impdontdelete\\chromedriver_win32\\chromedriver.exe");
		 //ChromeDriver driver = new ChromeDriver();
		 driver = new ChromeDriver();
		 driver.get("https://jupiter.cloud.planittesting.com/#/shop"); 
	}
	
	
	
		
  @Test(priority = 1) // This test verifies the correct shop page open or not by verifying the url.
  public void crtpageveri() throws IOException {
	  JupitorCartPage j1 = new JupitorCartPage(driver);
	  j1.crtpageverify();// Calling method crtpageverify to verify the csrt page
	  JupitorHomePage j2 = new JupitorHomePage(driver);
	  j2.Scnshot(); // calling method to take a screenshot.
	  
  }    
  
  
  @Test(priority = 2) // This test verifies the item is added to cart or not after clicking buy.
  public void shoooppge() throws IOException, BiffException { 
	  JupitorCartPage j1 = new JupitorCartPage(driver);
	  j1.shppge();
	 	  
  }
  
  
  
@Test(dataProvider = "dp") // This test case verifies checkout button , verfies order form , payment details, and confirms the order is placed or not.
  public void chhkcrt(String fname, String lname, String emla, String phna, String adrs, String crdtype, String cdrddtl) throws IOException, BiffException, InterruptedException { 
	  JupitorCartPage j1 = new JupitorCartPage(driver);
	 
	  j1.cartpgevalidtn(fname,lname,emla,phna,adrs,crdtype,cdrddtl); 	  
  }
  

  
  
  @DataProvider // Used to feed the data to the chkkrt method.
  public Object[][] dp() throws BiffException, IOException {
	  
	  readexcel rx = new readexcel();
	  int rowcnt = rx.getRowcount(2);
	  //System.out.println(rowcnt);
	  //int colcnt = rx.getColcount(0);
	  
	  
	  Object[][] info = new  Object[rowcnt][7];
	  
	  for(int i = 1; i<rowcnt; i++)
	  {
		  
			  info[i][0] = rx.getData(2, 0, i); //fname
			  info[i][1] = rx.getData(2, 1, i); //lname
			  info[i][2] = rx.getData(2, 2, i); //email
			  info[i][3] = rx.getData(2, 3, i); //Telephone
			  info[i][4] = rx.getData(2, 4, i); //addr
			  info[i][5] = rx.getData(2, 5, i); //card type
			  info[i][6] = rx.getData(2, 6, i); // card details
			  					 
		  
	  }
	  return info;
  }
  
  
  
  
     
  @AfterMethod // After method is used to do the necessery things 
  public void close()
  {
	  driver.close();
  }
}
