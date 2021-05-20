package PageObjectModel;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JupitorContactPage {
	
	
	WebDriver driver;
	
	//Locators
	By fnem = By.id("forename");	
	By lnem = By.id("surname");
	By eml = By.id("email");
	By phn = By.id("telephone");
	By cntmsg = By.id("message");	
	By prgbar= By.className("progress-info");	
	
	
//	By subbtn = By.className("btn-primary"); // Submit button on contact page
	
	By subbtn = By.xpath("//form[1]/div[1]/a[1]"); // Submit button on contact page
	
	
	

	
	By cntsucessmsg = By.xpath("//body[1]/div[2]/div[1]/div[1]/strong[1]"); // Submit button on contact page
	
	
	
	
	By backbtn = By.xpath("//body[1]/div[2]/div[1]/a[1]"); // Back button on sucess contct page.
	
	
	
	
	//Parameterize constructor use to initialize
	public JupitorContactPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void doContactpagevalid()
	{
	driver.manage().window().maximize();	
	Assert.assertEquals(driver.getCurrentUrl(), "https://jupiter.cloud.planittesting.com/#/contact");
	System.out.println("Contact paage verified!");
	}
	
	
	public void dofeedbck(String fname,String lname,String emla,String phna,String msg) throws IOException, InterruptedException
	{
		driver.manage().window().maximize();
		
		
		
		driver.findElement(fnem).sendKeys(fname);
		driver.findElement(lnem).sendKeys(lname);
		driver.findElement(eml).sendKeys(emla);
		driver.findElement(phn).sendKeys(phna);		
		driver.findElement(cntmsg).sendKeys(msg);
		
		driver.findElement(subbtn).click();
		WebDriverWait wait = new WebDriverWait(driver, 29);
		//WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(cntsucessmsg));
		
		Boolean element1 = wait.until(ExpectedConditions.invisibilityOfElementLocated(prgbar));
		
	}
	
	
	
	
	public void bckbtnvalid()
	{
	driver.manage().window().maximize();	
	driver.findElement(subbtn).click();
	
	Assert.assertEquals(driver.getCurrentUrl(), "https://jupiter.cloud.planittesting.com/#/contact");
	System.out.println("Back Button is verified!");
	}
	
	
	
	
		
	
	
}

