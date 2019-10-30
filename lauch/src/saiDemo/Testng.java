package saiDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng {
	
	@Test (enabled=false)
	public void valid() throws InterruptedException {

		WebDriver  driver;
		System.setProperty("webdriver.chrome.driver", "C:\\MyDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http://www.newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
		
		WebElement register=driver.findElement(By.xpath("//a[text()='REGISTER']"));
		register.click();
		
		WebElement fname=driver.findElement(By.xpath("//input[@name='firstName']"));
		fname.sendKeys("gani ");
		
		WebElement lname=driver.findElement(By.xpath("//input[@name='lastName']"));
		lname.sendKeys("bhai");
		
		WebElement phone=driver.findElement(By.name("phone"));
		phone.sendKeys("9848022338");
		
		WebElement email=driver.findElement(By.name("userName"));
		email.sendKeys("123sai@gmail.com");
		
		WebElement addr=driver.findElement(By.xpath("//input[@name='address1' and @maxlength='60']"));
		addr.sendKeys("raja street");
		
		WebElement cty=driver.findElement(By.name("city"));
		cty.sendKeys("warangal");

		//WebElement pc=driver.findElement(By.name("postalcode"));
		//pc.sendKeys("500001");
		

		WebElement cntry=driver.findElement(By.xpath("//select[@name='country']"));
		
		Select el1=new Select(cntry);
		el1.selectByIndex(5);
		//WebElement login1=driver.findElement(By.xpath("//input[@value='Log in']"));
		//login1.click();
		WebElement uname=driver.findElement(By.name("email"));
		uname.sendKeys("naga");
		
		WebElement pwd=driver.findElement(By.name("password"));
		pwd.sendKeys("password1234");
		
		WebElement cpwd=driver.findElement(By.name("confirmPassword"));
		cpwd.sendKeys("password1234");
		
		WebElement sbt=driver.findElement(By.xpath("//input[@name='register']"));
		sbt.click();
		

	Thread.sleep(1000);
	String A_title=driver.getTitle();
    String E_title="Demo Web Shop";
	Assert.assertEquals(A_title,E_title);
	System.out.println("success");
	}
@Test
public void addt() {
	int a=1;
	int b=1;
	Assert.assertEquals(a, b);
	System.out.println("hi");
}
@Test
public void aDd() {
	int a=1;
	int b=1;
	Assert.assertEquals(a, b);
	System.out.println("add");
}
}

	
	//WebElement  ft=driver.findElement(By.linkText("Forgot password?"));
	//ft.click();
	//Thread.sleep(1000);

	//String A_title=driver.getTitle();
    //String E_title="Demo Web Shop";
	//Assert.assertEquals(A_title,E_title);
	//System.out.println("success");