import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Doctor extends Person{
	private String specialization, department, room, id, full_name, gender, address, phone;
	ArrayList<Doctor> arrDoc;
    private ArrayList<Integer> indexes = new ArrayList<Integer>();
    private int searchIndex = 0;
	public Doctor(FileHandling file) throws IOException {
		super();
		getDocSheet(file);
		addAllDocObj(file);
	}
	
	public Doctor(String full_name, String id, String gender, String address, String phone, 
			String specialization, String room, String department){
		super(id, full_name, gender, address, phone);
		this.department = department;
		this.specialization = specialization;
		this.room = room;
	}
	public void getDocSheet(FileHandling file) throws IOException {
		file.readSheet("doctor");
	}
	public void newDoctor (FileHandling file) throws IOException{
		getDocSheet(file);
		Scanner input = new Scanner(System.in);
		Row row = file.createRowCell(file.lastRow()+1);
		System.out.println("Enter ID: ");
		id = "D-" + input.nextLine();
		System.out.println("Enter Full Name: ");
		full_name = input.nextLine();
		System.out.println("Enter Address: ");
		address = input.nextLine();
		System.out.println("Enter Gender: ");
		gender = input.nextLine();
		System.out.println("Enter Phone Number: ");
		phone = input.nextLine();
		System.out.println("Enter Specialization: ");
		this.specialization = input.nextLine(); 
		row.getCell(5).setCellValue(specialization);
		System.out.println("Enter Department: ");
		this.department = input.nextLine();
		row.getCell(7).setCellValue(department);
		System.out.println("Enter Room: ");
		this.room = input.nextLine();
		row.getCell(6).setCellValue(room);
		super.addPerson(row, id, full_name, gender, address, phone);
		file.writeSheet();
		arrDoc.add(new Doctor(full_name, id, gender, address, phone, specialization, room, department));
		input.close();
	}
	public int getSearchIndex() {
		return searchIndex;
	}

	public void setSearchIndex(int searchIndex) {
		this.searchIndex = searchIndex;
	}

	public ArrayList<Integer> getIndexes() {
		return indexes;
	}

	public void setIndexes(ArrayList<Integer> indexes) {
		this.indexes = indexes;
	}

	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	private void addAllDocObj(FileHandling file) {
		ArrayList<Doctor> doc = new ArrayList<Doctor>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			if (row == null) {
				doc.add(new Doctor("","","","","","","",""));
			} else {
			doc.add(new Doctor(row.getCell(1).getStringCellValue(),
					row.getCell(0).getStringCellValue(),
					row.getCell(2).getStringCellValue(),
					row.getCell(4).getStringCellValue(),
					row.getCell(3).getStringCellValue(),
					row.getCell(5).getStringCellValue(),
					row.getCell(6).getStringCellValue(),
					row.getCell(7).getStringCellValue()
					));
		}}
		this.arrDoc = doc;
	}
	public void removeObj(String str) {
		if (search(str)) {
			arrDoc.remove(getSearchIndex());
			viewAllDoc();
		} else {
			System.out.println("Input doesn't exist.");
		}
	}
	public boolean search(String str) {
		ArrayList<Doctor> arr = arrDoc;
		for (int i = 0; i < arr.size(); i++) {
			Doctor find = arr.get(i);
			if(find.getId().equals(str)) {
				setSearchIndex(i); 
				getIndexes().add(i);
				return true;
			}
		}
		return false;
	}
	public void updateDoctorSheet(FileHandling file) throws IOException {
		if(indexes.isEmpty()) {
			;
		} else {
		getDocSheet(file);
		file.updateSheet(getIndexes());
		}
	}		
	public void viewAllDoc() {
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Doctors - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		for(int i = 0; i<arrDoc.size(); i++) {
			this.arrDoc.get(i).printDoc();
		}
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Doctors - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		}
	public void printDoc() {
		System.out.println( super.toString() + "Department: " + getDepartment() + "\tRoom: "
				+ getRoom() + "\tSpecialization: " + getSpecialization());
	}
}


