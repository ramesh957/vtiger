package vtiger.Genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertyfile_Utility {

	/* This method will read the specific key value from the properyfile
	 * @param key
	 * @return
	 * throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.Properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		
	}
	
}