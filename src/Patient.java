import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Patient extends Person{
	private String blood_group, registration_date, id, full_name, gender, address, phone;
	ArrayList<Patient> arrPat;
	private ArrayList<Integer> indexes = new ArrayList<Integer>();
    private int searchIndex = 0;
	public Patient(FileHandling file) throws IOException {
		super();
		getPatSheet(file);
		addAllPatObj(file);
	}
	public Patient(String full_name, String id, String gender, String address, String phone, 
			String blood_group, String registration_date){
		super(id, full_name, gender, address, phone);
		this.blood_group = blood_group;
		this.registration_date = registration_date;
	
	}
	public void getPatSheet(FileHandling file) throws IOException {
		file.readSheet("patient");
	}
	public void newPatient (FileHandling file) throws IOException{
		getPatSheet(file);
		Scanner input = new Scanner(System.in);
		Row row = file.createRowCell(file.lastRow()+1);
		System.out.println("Enter ID: ");
		id = "P-" + input.nextLine();
		System.out.println("Enter Full Name: ");
		full_name = input.nextLine();
		System.out.println("Enter Address: ");
		address = input.nextLine();
		System.out.println("Enter Gender: ");
		gender = input.nextLine();
		System.out.println("Enter Phone Number: ");
		phone = input.nextLine();
		System.out.println("Enter Blood Group: ");
		this.blood_group = input.nextLine(); 
		row.getCell(5).setCellValue(blood_group);
		System.out.println("Enter registration date: ");
		this.registration_date = input.nextLine();
		row.getCell(6).setCellValue(registration_date);

		super.addPerson(row, id, full_name, gender, address, phone);
		file.writeSheet();
		arrPat.add(new Patient(full_name, id, gender, address, phone, blood_group, registration_date));
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
	public String getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	private void addAllPatObj(FileHandling file) {
		ArrayList<Patient> Pat = new ArrayList<Patient>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			if (row == null) {
				continue;
			}
			Pat.add(new Patient(row.getCell(1).getStringCellValue(),
					row.getCell(0).getStringCellValue(),
					row.getCell(2).getStringCellValue(),
					row.getCell(4).getStringCellValue(),
					row.getCell(3).getStringCellValue(),
					row.getCell(5).getStringCellValue(),
					row.getCell(6).getStringCellValue()
					));
		}
		this.arrPat = Pat;
	}
	public void removeObj(String str) {
		if (search(str)) {
			arrPat.remove(getSearchIndex());
			viewAllPat();
		} else {
			System.out.println("Input doesn't exist.");
		}
	}
	public boolean search(String str) {
		ArrayList<Patient> arr = arrPat;
		for (int i = 0; i < arr.size(); i++) {
			Patient find = arr.get(i);
			if(find.getId().equals(str)) {
				setSearchIndex(i); 
				getIndexes().add(i);
				return true;
			}
		}
		return false;
	}
	public void updatePatientSheet(FileHandling file) throws IOException {
		getPatSheet(file);
		file.updateSheet(getIndexes());
	}		

	public void viewAllPat() {
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Patient - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		for(int i = 0; i<arrPat.size(); i++) {
			this.arrPat.get(i).printPat();
		}
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Patient - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		}
	public void printPat() {
		System.out.println( super.toString() + "Blood Group: " + getBlood_group() + "\tregistration date: "
				+ getRegistration_date());
	}
}


