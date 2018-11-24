package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataInputProvider {

	public static Sheet sh;
	public static Row row;

	public static int rr = 0;
	public static int rowCount = 0;
	public static int colCount = 0;

	static String[][] data = null;

	public static Object[][] fetchData(String sheetName, String constraint){

		try(Workbook wb = WorkbookFactory.create(new File("./src/main/resources/TryOne.xlsx"))){

			//Sheet
			sh = wb.getSheet(sheetName+constraint);

			//to get no. of rows
			rowCount = sh.getLastRowNum();

			//to get no. of columns
			colCount = sh.getRow(0).getLastCellNum();
			
			data = new String[rowCount][colCount];

			for(int i =1;i<=rowCount;i++) 
			{
				row = sh.getRow(i);
				for(int j=0;j<colCount;j++) {
					String cellVal = "";
					cellVal = row.getCell(j).getStringCellValue();
					data[i-1][j]=cellVal;
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return data;

	}

}
