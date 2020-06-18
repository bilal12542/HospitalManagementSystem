import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileHandling {
	private Workbook wb;
	private Sheet sh;
	private FileInputStream fis;
	private FileOutputStream fos;
	private final String fl;
//	private static Row row;
//	private static Cell cell;
	public FileHandling(String file) throws Exception {
		this.fl = "./" + file; 
		this.fis = new FileInputStream(fl);
		this.wb = WorkbookFactory.create(fis);
	}
	public int lastRow() {
		return sh.getLastRowNum();
	}
	public int lastColumn() {
		return sh.getRow(0).getLastCellNum();
	}
	public Row createRowCell(int i) {
		Row row = createRow(i);
		for(int j = 0; j < lastColumn(); j++) {
			row.createCell(j);
		}
		return row;
	}
	public Row getRow(int i) {
		return sh.getRow(i);
	}
	public Row createRow(int i) {
		return sh.createRow(i);
	}
	public void readSheet(String sheet) throws IOException {
		this.sh = wb.getSheet(sheet);
	}
	public void writeSheet() throws IOException {
		fos = new FileOutputStream(fl);
		wb.write(fos);
		fos.flush();
		fos.close();
	}
}
