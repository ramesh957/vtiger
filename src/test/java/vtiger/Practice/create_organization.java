package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class create_organization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//step1 : Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		// step2 : login to application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		// step3 : navigate to organizations ;
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		// step4 : click on create organizations look up page
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// step5 : enter the mandatory fields
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("qspidershyd7");

		// step6 : save

	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	    
	    System.out.println("Organisation created successfully");

	}

}
