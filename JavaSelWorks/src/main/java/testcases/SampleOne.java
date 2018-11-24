package testcases;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SampleOne {

	public static Sheet sh;
	public static Row row;
	
	public static int count = 0;
	public static int rowCount = 0;
	public static int colCount = 0;
	
	static String[][] data = null;
	
	static List<Integer> cc = new ArrayList<Integer>();
	static List<String> dd = new ArrayList<String>();
	
	//public static String[][] fetchData(){
		
	public static void main(String[] args) {
		try(Workbook wb = WorkbookFactory.create(new File("./src/main/resources/TryOne.xlsx"))){
			
			//Sheet
			sh = wb.getSheetAt(0);
			
			//to get no. of rows
			rowCount = sh.getLastRowNum();
			
			//to get no. of columns
			colCount = (sh.getRow(0).getLastCellNum())-1;
			
			rowCountAnalyze();
			loopCols();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		//return data;
		//System.out.println(dd);
		System.out.println("The array:"+Arrays.deepToString(data));
		
	}

	public static void rowCountAnalyze() {
		for(int i =1;i<=rowCount;i++) {
			row = sh.getRow(i);
			if(row.getCell(1).getStringCellValue().equalsIgnoreCase("Y")) {
				count++;
				System.out.println("The count now: "+count);
				cc.add(i);
				System.out.println("The row with 'Y' is: "+i);
			}
		}
		System.out.println("=="+count   + "         "+colCount);
		data = new String[count][colCount];
	}
	
	public static void loopCols() {
		for(Integer i: cc) {
			row = sh.getRow(i);
			for(int j=0;j<colCount;j++) {
				String cellVal = "";
				cellVal = row.getCell(j).getStringCellValue();
				System.out.println("The cell's value: "+cellVal);
				data[i-1][j] = cellVal;
				//dd.add(cellVal);
			}
		}
		/*for(int i=1; i<rowCount;i++) {
			//if(row.getCell(1).getStringCellValue().equalsIgnoreCase("Y")) {
				row = sh.getRow(i);
				for(int j=0;j<colCount;j++) {
					String cellVal = "";
					cellVal = row.getCell(j).getStringCellValue();
					System.out.println(cellVal);
					data[i-1][j] = cellVal;
				}	
			//}
		}*/
	}

}
