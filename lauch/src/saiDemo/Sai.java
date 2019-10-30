package saiDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Sai {

	public static void main(String[] args) throws InterruptedException {
	
		
		/*WebDriver Snist;
		System.setProperty("webdriver.chrome.driver","C:\\MyDrivers\\chromedriver.exe");
		Snist=new ChromeDriver();
		Snist.navigate().to("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		
		
		Snist.manage().window().maximize();
		Thread.sleep(2000);
		
		Dimension d=new Dimension(300,700);
	    Snist.manage().window().setSize(d);
		Thread.sleep(1000);
		
		Point p=new Point(300,400);
		Snist.manage().window().setPosition(p);
		Thread.sleep(1000);
		*/
		//Snist.close();
//IEDRiver
		//WebDriver Snist;
	/*	System.setProperty("webdriver.ie.driver","C:\\MyDrivers\\IEDriverServer.exe");
	    Snist=new InternetExplorerDriver();
		Snist.navigate().to("http://www.yahoo.com");
		Snist.manage().window().maximize();
		Thread.sleep(2000);
		Dimension e=new Dimension(300,700);
	    Snist.manage().window().setSize(e);
		Thread.sleep(2000);
		
	    Snist.close();
	    //Mozilla
		
		*/
		WebDriver  driver;
		System.setProperty("webdriver.chrome.driver", "C:\\MyDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement signinlink=driver.findElement(By.className("ico-login"));
		signinlink.click();
		WebElement uname=driver.findElement(By.name("Email"));
		uname.sendKeys("123sai@gmail.com");
		WebElement paswrd=driver.findElement(By.name("Password"));
		paswrd.sendKeys("password123");
		WebElement login=driver.findElement(By.className("button-1 login-button"));
		login.click();
		Thread.sleep(1000);
				
		//WebElement signinlink=driver.findElement(By.linkText("SignIn"));
		
		
	}

}
