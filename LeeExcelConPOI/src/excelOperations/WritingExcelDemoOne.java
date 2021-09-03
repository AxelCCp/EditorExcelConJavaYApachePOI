package excelOperations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//WorkBook ---> Sheet ---> Rows --->
public class WritingExcelDemoOne {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Emp Info");
		Object[][] empdata = {
				{"EmpID","Name","Job"},
				{101,"David","Enginner"},
				{102,"Smith","Manager"},
				{101,"Scott","Analyst"},
		};
		
		int rows = empdata.length;   //4
		int cols = empdata[0].length;//3
		
		System.out.println(rows);
		System.out.println(cols);
		
		//RECORRE LAS FILAS Y LAS CREA
		for(int i=0;i<rows;i++) {
			XSSFRow row = sheet.createRow(i);
			//RECORRE LAS COLUMNAS Y LAS CREA 
			for(int j=0;j<cols;j++) {
			XSSFCell cell = row.createCell(j);
			Object value = empdata[i][j];
			
			if(value instanceof String) cell.setCellValue((String)value);
			if(value instanceof Integer) cell.setCellValue((Integer)value);
			if(value instanceof Boolean) cell.setCellValue((Boolean)value);
			}
		}
		String filepath = ".\\datafiles\\employee.xlsx";
		FileOutputStream outstream = new FileOutputStream(filepath);
		workbook.write(outstream);
		outstream.close();
		System.out.println("Employee.xlsx file written successfully...");
	}

}
