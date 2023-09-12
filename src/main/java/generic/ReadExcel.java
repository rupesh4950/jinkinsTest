package generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel implements FrameworkConstants{
	public static Workbook workbook;
	

	public String getData(String filePath,String sheetName,int row,int column) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(filePath);
		workbook=WorkbookFactory.create(fis);
		String data = workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public static Object[][] getMultipleData(String filePath,String sheetName,int start,int end) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream(filePath);
		System.out.println(filePath);
		workbook = WorkbookFactory.create(fis);
		int row_count = workbook.getSheet(sheetName).getPhysicalNumberOfRows();
		System.out.println("row"+row_count);
		int col_count=workbook.getSheet(sheetName).getRow(row_count-1).getPhysicalNumberOfCells();
		System.out.println(col_count);
		
		Object[][] data=new Object[end-start+1][col_count];
		for(int r=start, i=0;r<=end;r++) {
			 Row row = workbook.getSheet(sheetName).getRow(r);
			 
			for(int c=0;c<row.getPhysicalNumberOfCells();c++) {
				data[i][c]=row.getCell(c).getRichStringCellValue();
				//System.out.println(i+" "+c+" "+data[i][c]);
				i++;
			}
		}
		//System.out.println("end loop");
		return data;
	}

}
