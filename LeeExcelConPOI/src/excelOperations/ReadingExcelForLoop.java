package excelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelForLoop {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String excelFilePath = ".\\datafiles\\countries.xlsx";
		
		FileInputStream file  = new FileInputStream(excelFilePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		//XSSFSheet sheet = workbook.getSheet("Sheet1");  //it's the same.
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//WE GET THE ROWS QUANTITY
		int rows = sheet.getLastRowNum();
		//WE GET THE COLUMNS QUANTITY
		int cols = sheet.getRow(1).getLastCellNum();
		
		//NOW WE USE TWO FOR LOOP
		//ROWS LOOP 
		for(int i=0;i<=rows;i++) {
			
			XSSFRow row= sheet.getRow(i);
			
			//CELLS LOOP 
			for(int j=0;j<cols;j++) {
				XSSFCell cell = row.getCell(j);
				// WE OBTAIN THE CELLS TYPE
				switch(cell.getCellType()) {
					case STRING: System.out.print(cell.getStringCellValue()); break;
					case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
					case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;
				}
				System.out.print(" / ");
			}
			System.out.println("");
		}
		
	}

}
