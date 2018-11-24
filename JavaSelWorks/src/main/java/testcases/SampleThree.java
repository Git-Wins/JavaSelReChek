package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SampleThree {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		Workbook workbook = WorkbookFactory.create(new File("./src/main/resources/TryOne.xlsx"));

		Sheet sheet = workbook.getSheetAt(0);

		DataFormatter dataFormatter = new DataFormatter();
		
		int count = 0;

		System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row: sheet) {
            if(row.getCell(1).getStringCellValue().equalsIgnoreCase("Y")){
            	count++;
            }
        	
        	/*for(Cell cell: row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }*/
            System.out.println();
        }


	}

}
