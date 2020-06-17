import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileHandling {
	private static Workbook wb;
	private static Sheet sh;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static Row row;
	private static Cell cell;
	public FileHandling(String file) throws Exception {
		final String fl = "./" + file; 
		fis = new FileInputStream(fl);
		wb = WorkbookFactory.create(fis);
	}
	public void readSheet(String sheet) throws IOException {
		sh = wb.getSheet(sheet);
		int noOfRows = sh.getLastRowNum();
		System.out.println(noOfRows);
	}
}
