package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class sampleJDBCExecuteQuery {
public static void main(String[] args) throws SQLException {
	
	Driver driverRef = new Driver();
	// step1 : Register the driver
	DriverManager.registerDriver(driverRef);
	
	// step2 : get the connection with database
	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ramesh", "root", "root");
	//ResultSet result = con.createStatement().executeQuery("select * from customerinfo;");
	//step3 : issue create statement
	Statement state = con.createStatement();
	// step4 : execute the query
	ResultSet result = state.executeQuery("select * from customerinfo;");
	// step5 : close the database
while (result.next())
{
	System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
}
}

}
