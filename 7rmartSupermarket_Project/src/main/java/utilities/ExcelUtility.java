package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet   sh;
	
	public static String getStringData(int a,int b, String sheet) throws IOException 
	{
		f=new FileInputStream(Constant.TESTDATAFILE);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);// to get the details from the sheet in the workbook
		XSSFRow r =sh.getRow(a); // to get the details from the row in a sheet. since we haven't initialized it earlier, doing it here.
		XSSFCell c = r.getCell(b); // to get the details from a cell within a row.
		return c.getStringCellValue();// to get the value of a string (string value)from a cell.
	}
	
	public static int getIntegerData(int a,int b, String sheet) throws IOException 
	{
		f=new FileInputStream(Constant.TESTDATAFILE);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);// to get the details from the sheet in the workbook
		XSSFRow r =sh.getRow(a); // to get the details from the row in a sheet. since we haven't initialized it earlier, doing it here.
		XSSFCell c = r.getCell(b); // to get the details from a cell within a row.
		int az = (int)c.getNumericCellValue();
		return az;
		//return String.valueOf(az);
		//return c.getStringCellValue();// to get the value of a string (string value)from a cell.
	}
}
