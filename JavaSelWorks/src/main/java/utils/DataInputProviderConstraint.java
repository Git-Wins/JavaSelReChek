package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataInputProviderConstraint {

	public static Object[][] fetchExcelData(String sheetName) {

		Object[][] data = null;
		List<Integer> list = new ArrayList<Integer>();
		int count = 0;

		try (Workbook wb = WorkbookFactory.create(new File("./src/main/resources/TryTwo.xlsx"))) {

			// Sheet
			Sheet sh = wb.getSheet(sheetName);

			int colCount = (sh.getRow(0).getLastCellNum()) - 1;

			int rowCount = sh.getLastRowNum();

			for (int i = 1; i <= rowCount; i++) {
				if (sh.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase("Y")) {
					list.add(i);
				}
			}
			data = new String[list.size()][colCount];

			for (Integer hh : list) {
				count++;
				System.out.println("Count is: " + count);
				Row row = sh.getRow(hh);
				System.out.println("The row picked is Row: " + hh);
				for (int j = 0; j < colCount; j++) {
					CellType ct = row.getCell(j).getCellType();
					if (ct.toString().equalsIgnoreCase("STRING")) {
						String cellValS = row.getCell(j).getStringCellValue();
						data[count - 1][j] = cellValS;
					} else if (ct.toString().equalsIgnoreCase("NUMERIC")) {
						String cellValN = "" + (int) row.getCell(j).getNumericCellValue();
						data[count - 1][j] = cellValN;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}

}
