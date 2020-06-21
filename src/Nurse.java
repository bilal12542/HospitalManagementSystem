import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Nurse extends Person{
	private String id, full_name, gender, address, phone, department, ward;
	ArrayList<Nurse> arrNur;
	private ArrayList<Integer> indexes = new ArrayList<Integer>();
    private int searchIndex = 0;
	public Nurse(FileHandling file) throws IOException {
		super();
		getNurSheet(file);
		addAllNurObj(file);
	}
	public Nurse(String id, String full_name, String gender, String phone, String address, 
			String department, String ward) {
        super(id, full_name, gender, address, phone);
        this.department = department;
        this.ward = ward;
	}
	public void getNurSheet(FileHandling file) throws IOException {
		file.readSheet("nurse");
	}
	public void newNurse (FileHandling file) throws IOException{
		getNurSheet(file);
		Scanner input = new Scanner(System.in);
		int i =  file.lastRow();
		Row row = file.createRowCell(i+1);
		System.out.println("Enter ID: ");
		id = "N-" + input.nextLine();
		System.out.println("Enter Full Name: ");
		full_name = input.nextLine();
		System.out.println("Enter Address: ");
		address = input.nextLine();
		System.out.println("Enter Gender: ");
		gender = input.nextLine();
		System.out.println("Enter Phone Number: ");
		phone = input.nextLine();
		System.out.println("Enter Department: ");
		this.department = input.nextLine(); 
		row.getCell(6).setCellValue(department);
		System.out.println("Enter ward: ");
		this.ward = input.nextLine();
		row.getCell(5).setCellValue(ward);
		super.addPerson(row, id, full_name, gender, address, phone);
		file.writeSheet();
		arrNur.add(new Nurse(id, full_name, gender, phone, address, department, ward));
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
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	private void addAllNurObj(FileHandling file) {
		ArrayList<Nurse> nur = new ArrayList<Nurse>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			if (row == null) {
				nur.add(new Nurse("","","","","","",""));
			} else {

			nur.add(new Nurse(row.getCell(0).getStringCellValue(),
					row.getCell(1).getStringCellValue(),
					row.getCell(2).getStringCellValue(),
					row.getCell(3).getStringCellValue(),
					row.getCell(4).getStringCellValue(),
					row.getCell(5).getStringCellValue(),
					row.getCell(6).getStringCellValue()
					));
		}
		this.arrNur = nur;
	}
	public void removeObj(String str) {
		if (search(str)) {
			arrNur.remove(getSearchIndex());
			viewAllNurse();
		} else {
			System.out.println("Input doesn't exist.");
		}
	}
	public boolean search(String str) {
		ArrayList<Nurse> arr = arrNur;
		for (int i = 0; i < arr.size(); i++) {
			Nurse find = arr.get(i);
			if(find.getId().equals(str)) {
				setSearchIndex(i); 
				getIndexes().add(i);
				return true;
			}
		}
		return false;
	}
	public void updateNurseSheet(FileHandling file) throws IOException {
		if(indexes.isEmpty()) {
			;
		} else {
		getNurSheet(file);
		file.updateSheet(getIndexes());
		}
	}		

	public void viewAllNurse() {
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Nurse - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		for(int i = 0; i<arrNur.size(); i++) {
			this.arrNur.get(i).printNurse();
		}
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Nurse - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
	}
	public void printNurse() {
		System.out.println(super.toString()+ "Department: " + getDepartment()
				+ "\tWard: " + getWard());
	}
}
