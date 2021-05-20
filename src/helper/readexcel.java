package helper;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class readexcel {
	
	Workbook wb;
	Sheet sh;
	
	
	//Read the file first whenever this page opens 
	public readexcel() throws BiffException, IOException
	{
		wb = Workbook.getWorkbook(new File("src\\testData\\data.xls"));
		
	}
	
	public String getData(int shnum, int col , int row)
	{
		sh = wb.getSheet(shnum);
		String data = sh.getCell(col, row).getContents();
		
		return data;
	}
	
	
	public int getRowcount(int shnum)
	{
		sh = wb.getSheet(shnum);
		int cnt = sh.getRows();
		return cnt;
		
	}
	
	
}
