package vtiger.Practice;

import org.testng.annotations.Test;

public class TestNGPractice {
 @Test
 public void CreateCustomerTest()
 {
	 System.out.println("this is tc1 - customer is created" ); //passed
 }
 
 @Test(dependsOnMethods = "CreateCustomerTest")
 public void ModifyCustomerTest()
 { 
	 System.out.println("this is tc2 - customer is modified" ); //passed
 }
 @Test(dependsOnMethods = {"CreateCustomerTest","ModifyCustomerTest"})
 public void DeleteCustomerTest()

 {
	 System.out.println("this is tc3 - customer is deleted" ); //failed

 }
}
