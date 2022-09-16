package vtiger.Genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;


/** This class contains all the generic methods relted to database
 * @author ramesh
 */

public class Database_Utility {
	Driver DriverRef;
	Connection con = null;
	
	/* This methos will establish the connection of db
	 * @throws SQL EXCEPTION
	 */
	
 public void connecttoDB() throws SQLException
 { 
	 DriverRef =new Driver();
	 DriverManager.registerDriver(DriverRef);
	 DriverManager.getConnection(Constant_Utility.DBurl, Constant_Utility.DBUsername,Constant_Utility.DBPassword);
}
 /*This method will close the db connection
  * @ throws sql exception
  */
 public void closeDB() throws SQLException
 {
	 con.close();
 }

 /*  /*This method will execute a query and check for the expected data
  * if the expected data is found it will return the data
  * else it will return the null
  
  
 * @ param query
 * @ param collindex
 * @ param expData
 * @ return 
 * @ throws sQLException
  */

 public String executqueryAndVerifyTheData(String query, String collIndex, String expData) throws Exception 
 {
	 boolean flag=false;
	 ResultSet result= con.createStatement().executeQuery(query);
	 while(result.next())
	 {
		 String actData=result.getString(collIndex);
		 if(actData.contentEquals(expData))
		 {
			 flag=true;//flag rising event
			 break;
		 }
	 }
	 if(flag)
	 {
		 System.out.print("data present"+expData);
		 return expData;
	 }
	 else
	 {
		 System.out.print("data not present");
		 return "";
		 }
 }
}