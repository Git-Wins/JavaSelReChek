package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataInputProviderFillo {

	public static Object[][] fetchExcelData(String sheetName) {

		Object[][] data = null;
		List<String> colNames;
		int rowCount, colCount;
		Fillo fillo;
		Connection connection = null;
		Recordset rs = null;
		
		try {
			fillo = new Fillo();
			
			connection = fillo.getConnection("./src/main/resources/TryTwo.xlsx");

			rs = connection.executeQuery("Select * from "+ sheetName).where("YoN='Y'");

			rowCount = rs.getCount();

			colNames = rs.getFieldNames();

			colCount = (colNames.size())-1;

			System.out.println("Row-Count: " + rowCount);

			System.out.println("Column count: " + colCount);

			data = new Object[rowCount][colCount];

			for (int i = 0; i < rowCount; i++) { 
				rs.moveNext(); 
				for (int j = 0; j < colCount ; j++) { 
					data[i][j] = rs.getField(colNames.get(j));
				}
			}
			System.out.println(Arrays.deepToString(data));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			rs.close();
			connection.close();
		}

		return data;

	}

}
