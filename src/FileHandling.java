import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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
	public Sheet getSheet() {
		return sh;
	}
	public void updateSheet(ArrayList<Integer> indexes) throws IOException {
		for(int i: indexes) {
			//System.out.println(getRow(i+1).getCell(0).getStringCellValue());
			getSheet().removeRow(getRow(i+1));
		}
		indexes.clear();
		writeSheet();
	}
	public void writeSheet() throws IOException {
		fos = new FileOutputStream(fl);
		wb.write(fos);
		fos.flush();
		fos.close();
	}
}
