package PageObjectModel;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JupitorCartPage {
	
	
	WebDriver driver;
	
	//===================== Shop page Locators==============================
	By bybtn = By.xpath("//li[@id='product-1']//div//p//a[contains(text(),'Buy')]"); // buy button for item
	By crtcnt = By.xpath("//span[@class='cart-count ng-binding']"); // number of items in cart 	
//	By crtbtn = By.xpath("//a[contains(text(),'Cart')]"); // cart button on navbar
	By crtbtn = By.id("nav-cart");	
	By prdctnm = By.xpath("//body[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/h4[1]"); //Clicked product name
	By prdprc = By.xpath("//body[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/p[1]/span[1]"); //Clicked product price
//	By crtbtnchkout = By.xpath("//a[contains(text(),'Checkout')]");	
	By crtbtnchkout = By.className("btn-checkout");	 //Cart page checkout button
	By crtproductmsg = By.className("cart-msg "); // checkout page sucess msg	
	//By crtbtnchkout = By.xpath("//a[contains(text(),'Check')] ");	
	
	//==================== Cart page elements======================================================
	By crtpgeprodctnme = By.xpath("//body[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]"); //Clicked product price on  cart page	
	By crtpgeprodctprce = By.xpath("//body[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]"); //Clicked product price on  cart page	
	By crtpgeprodctqty = By.xpath("//body[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[3]/input[1]"); //Clicked product quantity on cart page	
	By crtpgeprodctsubttl = By.xpath("//body[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[4]"); //Clicked product subtotal on cart page
	
	
	//==================Checkout page form and payment details locators===================
	By fnem = By.id("forename");	
	By lnem = By.id("surname");
	By eml = By.id("email");
	By phn = By.id("telephone");
	By addr = By.id("address");	
	By prgbar= By.className("progress-info");	
	
	By crdtyp = By.id("cardType");	
	By crddetils = By.id("card");	
	
	By successmessage = By.className("alert-success");
	

	
	By submitbuttononcheckoutform = By.xpath("//button[normalize-space()='Submit']"); //Submit button on the checkout form

	

	//Parameterize constructor use to initialize
	public JupitorCartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void crtpageverify()
	{
	driver.manage().window().maximize();	
	Assert.assertEquals(driver.getCurrentUrl(), "https://jupiter.cloud.planittesting.com/#/shop");
	System.out.println("Shop page verified!");
	}
	
	
	public void shppge() throws IOException
	{
		driver.manage().window().maximize();
		driver.findElement(bybtn).click();	
		
		Assert.assertEquals(driver.findElement(crtcnt).getText(),"1");
		System.out.println("Product added sucessfully"+driver.findElement(crtcnt).getText()+"== 1");
		
		JupitorHomePage j1 = new JupitorHomePage(driver);
		
		j1.Scnshot();		
		
	}
	
	
	public void cartpgevalidtn(String fname,String lname,String emla,String phna,String adrs, String crdtype,String cdrddtl) throws InterruptedException, IOException 
	{
			driver.manage().window().maximize(); // window maximize
			driver.findElement(bybtn).click();	// Click on buy button
			driver.findElement(crtbtn).click(); // click on cart button on navbar
			//	Thread.sleep(3000); //Wait for cart page to load
			WebElement firstResult = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Checkout')]")));
			driver.findElement(crtbtnchkout).click();// click on checkout page
			//	Thread.sleep(3000);//	Wait for checkout page to load
			WebElement firstResult1 = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit']")));
			Assert.assertEquals(driver.getCurrentUrl(),"https://jupiter.cloud.planittesting.com/#/checkout"); // verify checkout page
			System.out.println("Checkout button is verified");	// if both urlls are same then pass the test case!!!
		
			
			driver.findElement(fnem).sendKeys(fname);
			driver.findElement(lnem).sendKeys(lname);
			driver.findElement(eml).sendKeys(emla);
			driver.findElement(phn).sendKeys(phna);		
			driver.findElement(addr).sendKeys(adrs);
			
	
			Select dropdown = new Select(driver.findElement(crdtyp));	
			dropdown.selectByVisibleText(crdtype);
			
			driver.findElement(crddetils).sendKeys(cdrddtl);
			
			JupitorHomePage j1 = new JupitorHomePage(driver);		
		    j1.Scnshot();	
			
			driver.findElement(submitbuttononcheckoutform).click();
			
			WebElement firstResult2 = new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Shopping Again »']")));
			
			
			WebDriverWait wait = new WebDriverWait(driver, 29);
			//WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(cntsucessmsg));
			
			Boolean element1 = wait.until(ExpectedConditions.invisibilityOfElementLocated(prgbar));
			
			System.out.println("Order is verified!");
				
			j1.Scnshot();
	
}
	
	
	
}

