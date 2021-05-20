package PageObjectModel;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JupitorHomePage {
	
	
	WebDriver driver;
	
	//Locators
	By unm = By.id("loginUserName");	
	By pass = By.id("loginPassword");
	By lgbtn = By.id("nav-login");
	
	
	By lgbtnsub = By.className("btn-primary");
	
	By caclbtn = By.className("btn-cancel");
	
	By errmsg = By.id("login-error");
	
	
	
	//Parameterize constructor use to initialize
	public JupitorHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void dohomepagevalid()
	{
	driver.manage().window().maximize();	
	Assert.assertEquals(driver.getCurrentUrl(), "https://jupiter.cloud.planittesting.com/#/home");
	System.out.println("Home paage verified!");
	}
	
	
	public void dologin(String userm,String passwd) throws IOException
	{
		driver.manage().window().maximize();
		driver.findElement(lgbtn).click();
		driver.findElement(unm).sendKeys(userm);
		driver.findElement(pass).sendKeys(passwd);
		driver.findElement(lgbtnsub).click();	
		
		Assert.assertEquals(driver.findElement(errmsg).getText(), "Your login details are incorrect");
		System.out.println("Error message verified");
		
		  JupitorHomePage j1 = new JupitorHomePage(driver);

		
		 j1.Scnshot();
		
		driver.findElement(caclbtn).click();
		
		
	}
	
	
	
	public void Scnshot() throws IOException
	{
	System.out.println("SC captured");
	 Date d = new Date();
     DateFormat df = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
     
     String time = df.format(d);
     
    File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    
    File f2 = new File("C:\\Users\\User\\eclipse-workspace\\JupitorToys_TestCases_PlanitTesting\\src\\img\\img" +time+ ".png");
    
    FileUtils.copyFile(f1, f2);
   
	}
	
	
	
	
	
	
}

