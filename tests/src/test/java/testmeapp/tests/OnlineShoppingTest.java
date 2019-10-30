package testmeapp.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;
import testmeapp.utility.Drivers;

public class OnlineShoppingTest {

	WebDriver driv;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	public void startReportBeforeTest() 
	{
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/adnan.html");
	       
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			 htmlReporter.config().setDocumentTitle("casestudyRESULT");
			 htmlReporter.config().setReportName("RESULTS");
			 htmlReporter.config().setTheme(Theme.DARK);
			 htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			 
	}
	
	
	@AfterMethod
	public void getResultAfterMethod(ITestResult result) throws IOException 
	{
	if(result.getStatus()==ITestResult.FAILURE) {
		if(result.getStatus() == ITestResult.FAILURE) {
	          logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	         
	          TakesScreenshot snapshot =   (TakesScreenshot)driv;
	          File src = snapshot.getScreenshotAs(OutputType.FILE);
	          String Path = System.getProperty("user.dir") +"/test-output/casestudyscreens/"+result.getName()+".png";
	          FileUtils.copyFile(src, new File(Path));
	          logger.addScreenCaptureFromPath(Path, result.getName());
	          logger.fail(result.getThrowable());
	      }
	      else if(result.getStatus() == ITestResult.SUCCESS) {
	    	  logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	      }
	      else {
	    	  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	          logger.skip(result.getThrowable());
	      }
	}	
	}
@Test(priority=1)
   public void testRegistration() throws InterruptedException 
      {
	logger = extent.createTest("Test Case 1", "PASSED test case");	
	driv=Drivers.getDriver("CRM");
		driv.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
       driv.manage().window().maximize();
       
       WebElement signup=driv.findElement(By.xpath("//a[@href='RegisterUser.htm']"));
       signup.click();
       
       driv.findElement(By.xpath("//*[@id=\'userName\']")).sendKeys("AbfJOEYTRIBBIANI");
       
       Thread.sleep(3000);
      
       
       WebElement frstname=driv.findElement(By.xpath(" //*[@id=\'firstName\']"));
       frstname.sendKeys("jacky");
       Thread.sleep(2000);
       String a=driv.findElement(By.xpath("//*[@id=\"err\"]")).getText(); 
       Assert.assertEquals("Available", a);
       
      driv.findElement(By.xpath(" //input[@name='lastName']")).sendKeys("k");
     
     //password 
  //WebElement pwd=
		  
      driv.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password123");
     
      //confirmpassword
  //WebElemnet cpwd=
		  
		 driv.findElement(By.xpath("//*[@id=\"pass_confirmation\"]")).sendKeys("password123");
    // Assert.assertEquals(pwd, pwd);
    
     driv.findElement(By.xpath("//*[@id=\"gender\" and @value=\"Male\"]")).click();;
    //*[@id="gender" and @value="Male"]
  
     WebElement email=driv.findElement(By.xpath("//*[@id=\"emailAddress\"]"));
     email.sendKeys("sainaga@gmail.com");//*[@id="emailAddress"]
     

     WebElement mobile=driv.findElement(By.xpath("//*[@id=\"mobileNumber\"]"));
     mobile.sendKeys("8074414440");
     
     WebElement dob=driv.findElement(By.xpath("//*[@id=\"dob\"]"));
     dob.sendKeys("10/06/1997");
     
     WebElement address=driv.findElement(By.xpath(" //*[@id=\"address\"]"));
     address.sendKeys("10-58,kknagar,thorrur,warangal");
     
     WebElement security=driv.findElement(By.xpath("//*[@id=\"securityQuestion\"]"));

		Select secu=new Select(security);
		secu.selectByIndex(1);
    
     WebElement sanws=driv.findElement(By.xpath("//*[@id=\"answer\"]"));
     sanws.sendKeys("Yellow");
     
  
    
//       WebElement neww=driv.findElement(By.name("//*[@id=\"err\"]"));
//       String n=neww.getText(); 
//    
//     String a="Available";
//       Assert.assertEquals(a, n);
      WebElement regis=driv.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[13]/div/input[1]"));
       regis.click();
    driv.close();
        
      }

	@AfterTest
	public void endReportAfterTest()
	{
		 extent.flush();
	}
	@Test(priority=2)
	public void testLogin() 
	{
	logger = extent.createTest("Test Case 2", "PASSED test case");
		driv=Drivers.getDriver("CRM");
		driv.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
        driv.manage().window().maximize(); 
	    driv.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click(); 
	    driv.findElement(By.xpath("//input[@name='userName']")).sendKeys("sainaga");
	     driv.findElement(By.xpath("//input[@name='password']")).sendKeys("sai123");
	     driv.findElement(By.xpath("//input[@name='Login']")).click();
         driv.close();	
	}
	@Test(priority=3)
	public void testCart() throws InterruptedException 
	{
		logger = extent.createTest("Test Case 3", "PASSED test case");
		driv=Drivers.getDriver("CRM");
	driv.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
    driv.manage().window().maximize(); 
    driv.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click(); 
    driv.findElement(By.xpath("//input[@name='userName']")).sendKeys("lalitha");
   driv.findElement(By.xpath("//input[@name='password']")).sendKeys("password123");
    driv.findElement(By.xpath("//input[@name='Login']")).click();
     
		
		 driv.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span")).click();Thread.sleep(2000); 
		 driv.findElement(By.xpath(" //*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span")).click();Thread.sleep(2000); 
		 driv.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span")).click(); Thread.sleep(2000); 
		 driv.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();Thread.sleep(1000); 
		 driv.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();Thread.sleep(1000); 
		 
		WebElement quan= driv.findElement(By.xpath("//*[@id=\"quantity_1\"]"));
		System.out.println("quantity is "+quan.isDisplayed());
		boolean s=quan.isDisplayed();
		boolean s1=true;
		Assert.assertEquals(s, s1);
		driv.close();
		
	}
	@Test(priority=4)
	public void testPayment() throws InterruptedException 
	{
		logger = extent.createTest("Test Case 4", "PASSED test case");
		driv=Drivers.getDriver("CRM");
		driv.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	   driv.manage().window().maximize(); 
	    driv.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click(); 
	   driv.findElement(By.xpath("//input[@name='userName']")).sendKeys("lalitha");
	    driv.findElement(By.xpath("//input[@name='password']")).sendKeys("password123");
	     driv.findElement(By.xpath("//input[@name='Login']")).click();
	     
			
			 driv.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span")).click();Thread.sleep(2000); 
			 driv.findElement(By.xpath(" //*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span")).click();Thread.sleep(2000); 
			 driv.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span")).click(); Thread.sleep(2000); 
			 driv.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();Thread.sleep(1000); 
			 driv.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();Thread.sleep(1000); 
			 driv.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();Thread.sleep(2000);
			// driv.findElement(By.xpath("//*[@id=\"add1\"]")).sendKeys("fla t101,sairam pg for men");
			 driv.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
			 Thread.sleep(2000);
			 driv.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div[1]/div[1]/div/label/i")).click();
			Thread.sleep(2000);
			 driv.findElement(By.xpath("//*[@id=\"btn\"]")).click();
			 driv.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).sendKeys("123456");
			 driv.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).sendKeys("Pass@456");
			 driv.findElement(By.xpath("//input[@value='LOGIN']")).click();
			 driv.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input")).sendKeys("Trans@456");
			 driv.findElement(By.xpath("//input[@value='PayNow']")).click();
			 driv.close();
	}
	/*@DataProvider
	  public Object[] dp() {
	    return new Object[] {
	      new Object[] { "sainagasai"}
	      };
	    

	}*/
}