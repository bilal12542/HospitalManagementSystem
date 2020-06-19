import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Patient extends Person{
	private String blood_group, registration_date, id, full_name, gender, address, phone;
	ArrayList<Patient> arrPat;
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
	private void addAllPatObj(FileHandling file) {
		ArrayList<Patient> Pat = new ArrayList<Patient>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
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
		System.out.println( super.toString() + "Blood Group: " + blood_group + "\tregistration date: "
				+ registration_date);
	}
	public void getPatSheet(FileHandling file) throws IOException {
		file.readSheet("patient");
	}
}


