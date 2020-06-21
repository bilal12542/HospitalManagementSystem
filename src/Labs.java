import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class Labs{
    private String test_name;
    private int lab_cost;
    private ArrayList<Labs> arrLabs;
    //public static int flag = 0;
    private ArrayList<Integer> indexes = new ArrayList<Integer>();
    private int searchIndex = 0;
    
    public Labs(FileHandling file) throws IOException {
    	getLabSheet(file);
		addAllLabObj(file);
    }
    public Labs(String test_name, int cost) {
    	this.test_name = test_name;
    	this.lab_cost = cost;
    }
	private void getLabSheet(FileHandling file) throws IOException {
		file.readSheet("labs");
	}
	public void newLab(FileHandling file) throws IOException{
		getLabSheet(file);
		Row row = file.createRowCell(file.lastRow()+1);
        Scanner input = new Scanner(System.in);
        System.out.print("Test Name:");
        this.test_name = input.nextLine();
		row.getCell(0).setCellValue(test_name);
        System.out.print("Cost:");
        this.lab_cost = input.nextInt();
		row.getCell(1).setCellValue(lab_cost);
		file.writeSheet();
		arrLabs.add(new Labs(test_name, lab_cost));
		input.close();
    }
    public ArrayList<Integer> getIndexes() {
		return indexes;
	}
	public void setIndexes(ArrayList<Integer> indexes) {
		this.indexes = indexes;
	}
	public int getSearchIndex() {
		return searchIndex;
	}
	public void setSearchIndex(int searchIndex) {
		this.searchIndex = searchIndex;
	}
	public int getLab_cost() {
		return lab_cost;
	}
	public void setLab_cost(int lab_cost) {
		this.lab_cost = lab_cost;
	}
	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	public void updateLab(FileHandling file) throws IOException {
		getLabSheet(file);
		file.updateSheet(getIndexes());
	}		
//		for(int i: indexes) {
//			
//			file.getSheet().removeRow(file.getRow(i+1));
//		}
//		indexes.clear();
//		file.writeSheet();
//	}
//	public void updateSheet(FileHandling file) throws IOException{
//		getLabSheet(file);
//		for (int i = 0; i < getArr().size(); i++) {
//			Row row = file.getRow(i+1);
//			Labs arr = getArr().get(i);
//			for (int j = 0; j < file.lastColumn(); j++) {
//				Cell cell = row.getCell(j);
//				if (cell.getCellType() == CellType.STRING) {	
//					if(cell.getStringCellValue().equals(arr)) {
//						System.out.println((int)cell.getStringCellValue());
//					}
//				} else {	
//					if (cell.getCellType() == CellType.NUMERIC){
//						System.out.println((int)cell.getNumericCellValue());			
//					}
//					continue;
//				}
//			}
//		}
//	}
	public boolean search(String str) {
		ArrayList<Labs> arr = arrLabs;
		for (int i = 0; i < arr.size(); i++) {
			Labs find = arr.get(i);
			if(find.getTest_name().equals(str)) {
				System.out.println(i);
				setSearchIndex(i); 
				indexes.add(i);
				System.out.println(indexes);
				System.out.println(getSearchIndex());
				return true;
			}
		}
		return false;
	}
	public void removeObj(String str) {
		if (search(str)) {
			arrLabs.remove(getSearchIndex());
			viewAllLabs();
		} else {
			System.out.println("Input doesn't exist.");
		}
	}
	private void addAllLabObj(FileHandling file) {
    	ArrayList<Labs> labs = new ArrayList<Labs>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			if (row == null) {
				labs.add(new Labs("", 0));
			} else {
			labs.add(new Labs(row.getCell(0).getStringCellValue(),
					(int) row.getCell(1).getNumericCellValue()
					));
			}
		}
		this.arrLabs = labs;
	}
	public void viewAllLabs() {
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Labs - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		for(int i = 0; i<arrLabs.size(); i++) {
			this.arrLabs.get(i).printLabs();
		}
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Labs - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		}
    public void printLabs(){
        System.out.println( "Test Name: " + getTest_name() + "\tCost: " + getLab_cost());
    }
}