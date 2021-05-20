package testScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ReadingProperties {
	
	public String ReadProp(String ElemntNa) throws IOException 
	
	{
		Properties p = new Properties(); // declaring property class object
		
		FileInputStream fls = new FileInputStream("src\\repository\\locator.properties"); // opening a propertirs file to acess the key -> value pair
		p.load(fls); // loading the data of file
		
		String ElementDetails = p.getProperty(ElemntNa); // it will search the property based on the varibale name ElemeNa and retun the appropriate valur.
		return ElementDetails;
	}
	
	
	
	public String ReadUrl(String urlNa) throws IOException // Reading URL from the file
	
	{
		Properties p = new Properties(); // declaring property class object
		
		FileInputStream fls = new FileInputStream("src\\repository\\url.properties"); // opening a propertirs file to acess the key -> value pair
		p.load(fls); // loading the data of file
		
		String ElementDetails = p.getProperty(urlNa); // it will search the property based on the varibale name ElemeNa and retun the appropriate valur.
		return ElementDetails;
	}
	
	
	public WebElement getWebElem(WebDriver driver , String Key) throws IOException // Identifying a web elements based on input: ElemntNa
	{
		
		WebElement webelem=null;
		ReadingProperties rp = new ReadingProperties();
		String locatrinfo = rp.ReadProp(Key); //id:loginUserName
		
		String locator[] = locatrinfo.split(":");// locator[0]: id ,locator[1]: loginUserName
		switch(locator[0])
		{
		case "id":
			webelem = driver.findElement(By.id(locator[1]));	
			break;
			
		case "name":
			webelem = driver.findElement(By.name(locator[1]));	
			break;
			
		case "xpath":
			 webelem = driver.findElement(By.xpath(locator[1]));
			 break;
			 
		case "class":
			 webelem = driver.findElement(By.className(locator[1]));
			 break;
		}
		
		return webelem;
		
	}

}
