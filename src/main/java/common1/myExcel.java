package common1;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class myExcel {
	
	public XSSFWorkbook wb = null;
	public XSSFSheet sh = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	
	public Object[][] loadXlData2Array(String xlPath, String sheetName) throws IOException {
		wb = getExcel(xlPath); sh = wb.getSheet(sheetName);
		
		int rowIndex = sh.getLastRowNum();
		int colIndex = sh.getRow(0).getLastCellNum();
		
		Object[][]  obj = new Object[rowIndex][colIndex];
		
		for(int i=0; i <rowIndex; i++) {
			row = sh.getRow(i+1);
			for(int j=0; j <colIndex; j++) {
				cell = row.getCell(j);
				obj[i][j] = convertToString(cell);
			}
		}
				
		return obj;
	}
	
	
	public XSSFWorkbook getExcel(String xlPath) throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(xlPath);
		wb = new XSSFWorkbook(fis); 
		fis.close();
		return wb;
	}
			
	public int rowCount(String xlPath, String sheetName) throws FileNotFoundException, IOException {
		return getExcel(xlPath).getSheet(sheetName).getLastRowNum();
	}
	
	public int colCount(String xlPath, String sheetName) throws FileNotFoundException, IOException {   
		return getExcel(xlPath).getSheet(sheetName).getRow(0).getLastCellNum() - 1;
	}
	
	public String getCellValue(String xlPath, String sheetName, int rowIndex, int colIndex) throws FileNotFoundException, IOException {   
		cell = getExcel(xlPath).getSheet(sheetName).getRow(rowIndex).getCell(colIndex);
		return convertToString(cell);
	}
	
	public static String convertToString (XSSFCell cell) {
		
		switch (cell.getCellType()) 
		{
		case _NONE: return "";
		case BLANK: return "";
		case BOOLEAN: return Boolean.toString(cell.getBooleanCellValue());
		
		case NUMERIC: 
			if(DateUtil.isCellDateFormatted(cell)) { return (new SimpleDateFormat("dd-MMM-yyyy").format(cell.getDateCellValue())) ;}
			else {return Integer.toString((int) cell.getNumericCellValue());}
		
		case STRING	: return cell.getStringCellValue(); 
		//case ERROR:
		//case FORMULA:
		default: return cell.getStringCellValue();
		}
		
	}
	
	
}
