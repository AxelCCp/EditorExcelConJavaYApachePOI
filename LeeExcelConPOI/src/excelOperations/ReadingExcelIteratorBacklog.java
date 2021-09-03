package excelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelIteratorBacklog {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String excelFilePath = ".\\datafiles\\BackLog_V21 (1).xlsx";
		
		FileInputStream file  = new FileInputStream(excelFilePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		//XSSFSheet sheet = workbook.getSheet("Sheet1");  //it's the same.
		XSSFSheet sheet = workbook.getSheetAt(2);
		
		//NOW WE USE ITERATOR
		Iterator iterator = sheet.iterator();
		while(iterator.hasNext()) {
			XSSFRow row = (XSSFRow) iterator.next();
		 	Iterator cellIterator = row.cellIterator();
		 	
		 	while(cellIterator.hasNext()) {
		 		XSSFCell cell = (XSSFCell) cellIterator.next();
		 		switch(cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue());
						break;
					case NUMERIC: 
						System.out.print(cell.getNumericCellValue()); 
						break;
					case BOOLEAN: 
						System.out.print(cell.getBooleanCellValue());
						break;
					case FORMULA: 
						System.out.println(cell.getCachedFormulaResultType());
						break;
					case ERROR: 
						System.out.println(cell.getErrorCellValue());
						break;
					
		 		}
		 		System.out.print(" / ");
		 	}
		 	System.out.println("");
		}
		
		
		
			
	}

}
