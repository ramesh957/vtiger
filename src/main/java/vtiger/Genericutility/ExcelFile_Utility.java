package vtiger.Genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile_Utility {
/* This method will read the data from excel sheet and return the value 
 * @param sheet
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IoExdception
 */
	public String readataFromExcel(String sheet,int row,int cell) throws IOException, EncryptedDocumentException, InvalidFormatException
	{
		FileInputStream fis = new FileInputStream(Constant_Utility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row r=s.getRow(row);
		Cell cel=r.getCell(cell);
		String value=cel.getStringCellValue();
		wb.close();
		return value;
	}
	/**
	 * this method will return the last row number in particular sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentExceotion
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
		public int getRowCount(String sheet)throws EncryptedDocumentException, IOException, InvalidFormatException
		{
			FileInputStream fis = new FileInputStream(Constant_Utility.ExcelFilePath);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheet);
			int lastRow=s.getLastRowNum();
			return lastRow;
		}
		/**
		 * This method will write data into excel sheet
		 * @param sheet
		 * @param row
		 * @param cel
		 * @param value
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 * @throws InvalidFormatException 
		 */
		public void writeDataIntoExcel(String sheet,int row,int cel,String value)throws EncryptedDocumentException,IOException, InvalidFormatException
		{
			FileInputStream fis=new FileInputStream(Constant_Utility.ExcelFilePath);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet(sheet);
			Row r=s.getRow(row);
			Cell cell=r.createCell(cel);
			cell.setCellValue(value);
			
			FileOutputStream fos=new FileOutputStream(Constant_Utility.ExcelFilePath);
			wb.write(fos);
			wb.close();
	}
		
		}


   


