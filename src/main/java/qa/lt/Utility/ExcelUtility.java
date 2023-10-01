package qa.lt.Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static XSSFWorkbook excelBook;
	public static XSSFSheet excelSheet;
	
	public static String  getData(int rowNum,int ColNum) throws IOException
	{
		FileInputStream inp=new FileInputStream("C:\\Users\\bency\\OneDrive\\Desktop\\ST_main_project\\ICTAK_LEARNERTRACKER\\src\\main\\resources\\login_details.xlsx");
		excelBook=new XSSFWorkbook(inp);
		excelSheet=excelBook.getSheetAt(0);
		DataFormatter df=new DataFormatter();
		String value = df.formatCellValue(excelSheet.getRow(rowNum).getCell(ColNum));
		return value;
	}
}
