package vtiger.Practice;


	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;


	public class CreateOrganization {


		public static void main(String[] args) throws InvalidFormatException, IOException, AWTException  {
			// TODO Auto-generated method stub
	         WebDriver  driver;
	         // generate random number to avoid duplicate data
	         Random r = new Random();
	         int RANDOM = r.nextInt(1000);
	         // STEP1 : READ THE NECESSARY DATa
	         FileInputStream fisp = new FileInputStream("./src/test/resources/commonData.Properties");
	         Properties pobj = new Properties();
	         pobj.load(fisp);
	         String BROWSER = pobj.getProperty("browser");
	         String URL = pobj.getProperty("url");
	         String USERNAME = pobj.getProperty("username");
	         String PASSWORD = pobj.getProperty("password");
	         // STEP2 : Excel sheet Test DATa
	         
	      FileInputStream fise = new FileInputStream("./src/test/resources/testdata.xlsx");
	   Workbook wb = WorkbookFactory.create(fise);
	   
	   Sheet sh = wb.getSheet("ORGANISATION");
	   Row row = sh.getRow(1); 	 	 		
	   Cell cel = row.getCell(2);
	   String ORGNAME = cel.getStringCellValue(); 
		
		
	    // STEP3 : Launch the browser ------> Runtime Polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
				{
			driver = new ChromeDriver();
			System.out.println("---- chrome browser launched successfully");
				}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		System.out.println("---- firefox browser launched successfully");
		}
		else
		{
		System.out.println("----browser invalid ");
		driver = new ChromeDriver();
		System.out.println("---- chrome browser launched successfully");
		}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get(URL);
		 
		    // STEP4 : Login to application
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		    // STEP5 : navigate to organisations 
		 driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME+RANDOM); 
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			//WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

/*Actions act = new Actions(driver);
act.moveToElement(e);
act.click();
/*WebDriverWait wait = new  WebDriverWait(driver,10);
 
 wait.until(ExpectedConditions.visibilityOf(e));
 Robot rc = new Robot();
 rc.keyPress(KeyEvent.VK_DOWN);
 rc.keyRelease(KeyEvent.VK_DOWN);
 rc.keyPress(KeyEvent.VK_DOWN);
 rc.keyRelease(KeyEvent.VK_DOWN);*/


 
 
 System.out.println("----Scenario executed Successfully---");

		}
		}	
		
		

		

