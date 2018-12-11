/*package testcases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TCSample {

	public static Sheet sh;
	public static Row row;

	public static int rr = 0;
	public static int rowTotalCount = 0;
	public static int colCount = 0;

	static Object[][] data = null;

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		try (Workbook wb = WorkbookFactory.create(new File("./src/main/resources/TryTwo.xlsx"))) {

			List<Integer> list = new ArrayList<Integer>();

			// Sheet
			sh = wb.getSheet("Sheet1");

			// to get no. of rows
			int rowCount = sh.getLastRowNum();

			// to get no. of columns
			colCount = (sh.getRow(0).getLastCellNum()) - 1;

			// data = new String[rowCount][colCount];

			for (int i = 0; i < rowCount + 1; i++) {
				// Row row = sh.getRow(i);
				if (sh.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase("Y")) {
					list.add(i);
				}
			}

			System.out.println(list);

			data = new String[list.size()][colCount];

			for (Integer g : list) {
				Row row = sh.getRow(g);
				for (int j = 0; j < colCount; j++) {
					CellType ct = row.getCell(j).getCellType();
					if (ct.toString().equalsIgnoreCase("STRING")) {
						String cellValS = row.getCell(j).getStringCellValue();
						data[i - 1][j] = cellValS;
					} else if (ct.toString().equalsIgnoreCase("NUMERIC")) {
						String cellValN = "" + (int) row.getCell(j).getNumericCellValue();
						;
						data[i - 1][j] = cellValN;
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// System.out.println(Arrays.deepToString(data));

	}

}
*/