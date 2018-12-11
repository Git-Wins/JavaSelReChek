package testcases;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReadFillo {

	public static void main(String[] args) throws FilloException {

		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("./src/main/resources/TryTwo.xlsx");
		String strQuery = "Select * from Sheet1";
		Recordset recordset = connection.executeQuery(strQuery);

		while (recordset.next()) {
			System.out.println(recordset.getField("SearchInput"));
		}

		recordset.close();
		connection.close();

	}

}