package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class selectbrowser {
	static WebDriver driver = null;
	
		public static WebDriver getBrowser(String b1, String Url)
		
			{
					if(b1.equalsIgnoreCase("chrome"))
						{
							System.setProperty("webdriver.chrome.driver","C:\\impdontdelete\\chromedriver_win32\\chromedriver.exe");
							 //ChromeDriver driver = new ChromeDriver();
							 driver = new ChromeDriver();
							 driver.get("https://jupiter.cloud.planittesting.com/#/home"); 
						}
					
					else if(b1.equalsIgnoreCase("Firefox"))
					{
						System.setProperty("webdriver.gecko.driver","C:\\impdontdelete\\chromedriver_win32\\geckodriver.exe");
						 //ChromeDriver driver = new ChromeDriver();
						 driver = new FirefoxDriver();
						 driver.get("https://jupiter.cloud.planittesting.com/#/home"); 
					}
					
					else if(b1.equalsIgnoreCase("ie"))
					{
						System.setProperty("webdriver.ie.driver","C:\\impdontdelete\\chromedriver_win32\\IEDriverServerdriver.exe");
						 //ChromeDriver driver = new ChromeDriver();
						 driver = new InternetExplorerDriver();
						 driver.get("https://jupiter.cloud.planittesting.com/#/home"); 
					}
					
					driver.get(Url);
					return driver;
			}
}
