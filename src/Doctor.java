import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Doctor extends Person{
	private String specialization, department;
	private String room;
	private String id;
	private String full_name;
	private String gender;
	private String address;
	private String phone;
	public Doctor() {
		super();
	}
	public Doctor(String full_name, String id, String gender, String address, String phone, 
			String specialization, String room, String department){
		super(id, full_name, gender, address, phone);
		this.department = department;
		this.specialization = specialization;
		this.room = room;
	}
	public void newDoctor (Sheet sh){
		Scanner input = new Scanner(System.in);
		int i =  sh.getLastRowNum();
		Row row = sh.createRow(i+1);
		for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) {
	        row.createCell(j);                
		}
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
		row.getCell(5).setCellValue("specialization");
		System.out.println("Enter Department: ");
		this.department = input.nextLine();
		row.getCell(7).setCellValue(department);
		System.out.println("Enter Room: ");
		this.room = input.nextLine();
		row.getCell(6).setCellValue(room);
		super.addPerson(row, id, full_name, gender, address, phone);

	}
	public ArrayList<Doctor> viewAll(Sheet sh) {
		ArrayList<Doctor> doc = new ArrayList<Doctor>();
		for(int i = 0; i < sh.getLastRowNum(); i++) {
			doc.add(new Doctor(sh.getRow(i+1).getCell(1).getStringCellValue(),
					sh.getRow(i+1).getCell(0).getStringCellValue(),
					sh.getRow(i+1).getCell(2).getStringCellValue(),
					sh.getRow(i+1).getCell(4).getStringCellValue(),
					String.valueOf(sh.getRow(i+1).getCell(3).getNumericCellValue()),
					sh.getRow(i+1).getCell(5).getStringCellValue(),
					sh.getRow(i+1).getCell(6).getStringCellValue(),
					sh.getRow(i+1).getCell(7).getStringCellValue()
					));
		}
		return doc;
	}
	
	public void printDoc() {
		System.out.println( super.toString() + "Department: " + department + "\tRoom: "
				+ room + "\tSpecialization: " + specialization);
	}
}


