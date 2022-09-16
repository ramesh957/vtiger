package vtiger.Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel_handling2 {

	public static void main(String[] args) throws Exception {
 FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	Sheet sh = book.getSheet("Sheet2");
	Row r = sh.getRow(3);
	Cell c= r.getCell(2);
	String value = c.getStringCellValue();
	System.out.println(value);
	
	}

}
