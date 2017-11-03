package testCases;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData
{
    public static void main(String args[]) throws Exception
    {
		String path = "C://Users//lyndam//workspace//SeleniumTutorial//src//testData//";
		String file = "AmazonSearch.xlsx";
		String sheetName = "AmazonBooks";
		String header = "Genre";
    	
        FileInputStream fis = new FileInputStream(path + file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow row = sheet.getRow(0);
        XSSFCell cell = null;

 		int colNum = -1;
        
        for(int i=0; i < row.getLastCellNum(); i++)
        {
        	  String t = row.getCell(i).getStringCellValue().trim();
			  System.out.println("Header: " + t);	
            if(row.getCell(i).getStringCellValue().trim().equals(header))
            { 
            	colNum = i;
            	i = row.getLastCellNum();
            }
        }        
        
        row = sheet.getRow(1);
        cell = row.getCell(colNum);

        String value = cell.getStringCellValue();
      System.out.println("Value of the " + header + " Cell is - "+ value);
    }

}
