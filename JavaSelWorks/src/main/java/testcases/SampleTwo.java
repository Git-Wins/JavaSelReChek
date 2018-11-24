package testcases;

import java.io.File;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SampleTwo {



	public static void main(String[] args) {
		
		String[][] data = null;

		try(Workbook wb = WorkbookFactory.create(new File("./src/main/resources/TryOne.xlsx"))){

			//Sheet
			Sheet sh = wb.getSheetAt(0);

			//to get no. of rows
			int rowCount = sh.getLastRowNum();

			//to get no. of columns
			int colCount = (sh.getRow(0).getLastCellNum())-1;
			
			System.out.println(rowCount+"  "+colCount);
			
			data = new String[rowCount][colCount];
			
			for(int i =1;i<=rowCount;i++) {
				Row row = sh.getRow(i);
				//if(row.getCell(1).getStringCellValue().equalsIgnoreCase("Y")) {
					for(int j=0;j<colCount;j++) {
						String cellVal = "";
						cellVal = row.getCell(j).getStringCellValue();
						System.out.println(cellVal);
						if(cellVal.equalsIgnoreCase("null")) {
							System.out.println("Oops it's a null !!!");
						}else {
							data[i-1][j] = cellVal;
						}
						
					//}
				}
			}
			
			System.out.println(Arrays.deepToString(data));

		}catch(Exception e) {
			e.printStackTrace();
		}
	}



}