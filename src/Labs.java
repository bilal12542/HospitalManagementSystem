import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Labs{
    private String test_name;
    private int lab_cost;
    private ArrayList<Labs> arrLabs;
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
    public ArrayList<Labs> getArr() {
		return arrLabs;
	}
	public void setArr(ArrayList<Labs> arrLabs) {
		this.arrLabs = arrLabs;
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
	public void search(String id) {
		ArrayList<Labs> arr = getArr();
		if(arr.contains(id)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
	private void addAllLabObj(FileHandling file) {
    	ArrayList<Labs> labs = new ArrayList<Labs>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			labs.add(new Labs(row.getCell(0).getStringCellValue(),
					(int) row.getCell(1).getNumericCellValue()
					));
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