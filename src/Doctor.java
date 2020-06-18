import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Doctor extends Person{
	private String specialization, department, room, id, full_name, gender, address, phone;
	ArrayList<Doctor> arrDoc;
	public Doctor(FileHandling file) throws IOException {
		super();
		file.readSheet("doctor");
		addAllDocObj(file);
	}
	public Doctor(String full_name, String id, String gender, String address, String phone, 
			String specialization, String room, String department){
		super(id, full_name, gender, address, phone);
		this.department = department;
		this.specialization = specialization;
		this.room = room;
	}
	public void newDoctor (FileHandling file) throws IOException{
		Scanner input = new Scanner(System.in);
		int i =  file.lastRow();
		Row row = file.createRowCell(i+1);
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
	}
	private void addAllDocObj(FileHandling file) {
		ArrayList<Doctor> doc = new ArrayList<Doctor>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			doc.add(new Doctor(row.getCell(1).getStringCellValue(),
					row.getCell(0).getStringCellValue(),
					row.getCell(2).getStringCellValue(),
					row.getCell(4).getStringCellValue(),
					row.getCell(3).getStringCellValue(),
					row.getCell(5).getStringCellValue(),
					row.getCell(6).getStringCellValue(),
					row.getCell(7).getStringCellValue()
					));
		}
		this.arrDoc = doc;
	}
	public void viewAll() {
		for(int i = 0; i<arrDoc.size(); i++) {
			this.arrDoc.get(i).printDoc();
		}
	}
	public void printDoc() {
		System.out.println( super.toString() + "Department: " + department + "\tRoom: "
				+ room + "\tSpecialization: " + specialization);
	}
}


