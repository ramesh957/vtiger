package vtiger.Genericutility;


import java.util.Date;
import java.util.Random;

/* This contains all the java specific generic methods
 * @authorname ramesh

 */
public class Java_Utility {

	/* THIS METHOD WILL GENERATE NUMBER FOR EVERY EXECUTION 
	 * @return 
	 */
	
	public int getRandomNumber()
	{
		Random r = new Random ();
		int ran = r.nextInt(1000);
		return ran;
		
	}
	
	/* This Method will generate the current and time in specific format
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date date = new Date();
		String d = date.toString();
		return d;
		
	}
	/* This Method will generate current date and time in specific format
	 * return
	 */

public String getSystemDateInFormat()
{
	Date d = new Date();
	String [] dArr = d.toString().split(" ");
	String date = dArr[2];
	String month = dArr[1];
	String year = dArr[5];
	String time = dArr[3].replace(":", "-");
	String CurrentDateAndTime = date+" "+month+" "+year+" "+time;
	return CurrentDateAndTime;
	



}

	
}

