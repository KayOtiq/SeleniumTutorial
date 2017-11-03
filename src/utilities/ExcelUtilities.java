package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities {
	
	private static XSSFSheet ExcelWSheet;
	 
	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	
	//Get data from Excel data sheet and place into an array in memory
	
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
		 
		   //String[][] tabArray = null;
			Object[][] tabArray = null;

		   try {

			   FileInputStream ExcelFile = new FileInputStream(FilePath);

			   // Access the required test data sheet

			   ExcelWBook = new XSSFWorkbook(ExcelFile);

			   ExcelWSheet = ExcelWBook.getSheet(SheetName);

			   int startRow = 1;

			   int startCol = 1;

			   int ci,cj;

			   int totalRows = ExcelWSheet.getLastRowNum();

			   // you can write a function as well to get Column count

			   int totalCols = 2;

			   tabArray=new String[totalRows][totalCols];

			   ci=0;

			   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

				  cj=0;

				   for (int j=startCol;j<=totalCols;j++, cj++){

					   tabArray[ci][cj]=getCellData(i,j);

					   System.out.println(tabArray[ci][cj]);  

						}

					}

				}

			catch (FileNotFoundException e){

				Log.error("Class:  Excel Utilities  |  Method: setExcelFile  |  Exception Desc: Could not read the Excel sheet");

				e.printStackTrace();

				}

			catch (IOException e){

				Log.error("Class:  Excel Utilities  |  Method: setExcelFile  |  Exception Desc: Could not read the Excel sheet");

				e.printStackTrace();

				}

			return(tabArray);

			}


//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {

			// Open the Excel file

		FileInputStream ExcelFile = new FileInputStream(Path);

		// Access the required test data sheet

		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e){
			
			Log.error("Class:  Excel Utilities  |  Method: setExcelFile  |  Exception Desc: " + e.getMessage());

			throw (e);

		}

}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			
			int dataType = Cell.getCellType();
			if (dataType == 3) {
				return "";
			}else {
				String CellData = Cell.getStringCellValue();
				return CellData;
			}


			}catch (Exception e){

				Log.error("Class:  Excel Utilities  |  Method: getCellData  |  Exception Desc: " + e.getMessage());
				throw (e);

			}

}

@SuppressWarnings({ "rawtypes", "unchecked" })
public static List getSheetData() throws Exception {
	
	List dataList = new ArrayList();
	
	try {
		java.util.Iterator rows = ExcelWSheet.rowIterator();
		
		while (rows.hasNext()) {
            XSSFRow row = ((XSSFRow) rows.next());
            // int r=row.getRowNum();
            java.util.Iterator cells = row .cellIterator();
            int i = 0;
            String[] testData= new String[3];
            while (cells.hasNext()) {

                XSSFCell cell = (XSSFCell) cells.next();
                String value = cell.getStringCellValue();
                if (!value.equals(null)) {
                     testData [i] = value;
                     i++;
                }
            }
            dataList.add(testData);
        }
	
	}
	catch (Exception e) {
		e.printStackTrace();
	}
return dataList;
}

public static String getCellDataByHeader( String headerName, int rowNum) {
	try {
		XSSFRow row = ExcelWSheet.getRow(0);
        XSSFCell cell = null;

 		int colNum = -1;

		int dataType = Cell.getCellType();
		
		if (dataType== 3) {
			return "";
			
		}else {
		
			for(int i=0; i < row.getLastCellNum(); i++)
	        {
	            if(row.getCell(i).getStringCellValue().trim().equals(headerName))
	            { 
	            	colNum = i;
	            	i = row.getLastCellNum();
	            }
	        }        
	        
	        row = ExcelWSheet.getRow(rowNum);
	        cell = row.getCell(colNum);

	        return cell.getStringCellValue();
		}
		
	}catch(Exception e)
      {
          e.printStackTrace();
          return "row "+rowNum+" or column "+ headerName +" does not exist";
      }
 
}

//This method is to write in the Excel cell, Row num and Col num are the parameters

@SuppressWarnings("static-access")
public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

		try{

			Row  = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

			}catch(Exception e){
				
				Log.error("Class:  Excel Utilities  |  Method: FileOutputStream  |  Exception Desc: " + e.getMessage());

				throw (e);

		}

	}


//This method is to find a row based on the test case name
	public static int getRowContains(String sTestCaseName, int colName) throws Exception {
		
		int i;
		
		try {
			int rowCount = ExcelWSheet.getLastRowNum();
			for (i = 0; i < rowCount; i++){
				if(ExcelUtilities.getCellData(i, colName).equalsIgnoreCase(sTestCaseName)){
					break;
				}
			}
			return i;
			
		}catch (Exception e) {
			Log.error("Class: ExcelUtilities  |  Method:  getRowContains  | Exception Desc:  " + e.getMessage());
			throw (e);
			
		}
	}


}
