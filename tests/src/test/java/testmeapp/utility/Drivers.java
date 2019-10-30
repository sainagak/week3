package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Drivers {

	
		public static WebDriver getDriver(String Browser) {
			if(Browser.equals("CRM"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\MyDrivers\\chromedriver.exe");
				return new ChromeDriver();
			}
			else if(Browser.equals("IE"))
			{
				System.setProperty("webdriver.ie.driver","\"C:\\MyDrivers\\IEDriverServer.exe");
				return new ChromeDriver();
			}
			return null;
		}
		
	}


