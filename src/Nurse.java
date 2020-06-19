import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Nurse extends Person{
	private String id, full_name, gender, address, phone, department, ward;
	ArrayList<Nurse> arrNur;
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
	private void addAllNurObj(FileHandling file) {
		ArrayList<Nurse> nur = new ArrayList<Nurse>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
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
	public void viewAllNurse() {
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Nurse - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		for(int i = 0; i<arrNur.size(); i++) {
			this.arrNur.get(i).printNurse();
		}
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Staffs - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
	}
	public void printNurse() {
		System.out.println(super.toString()+ "Department: " + this.department
				+ "\tWard: " + this.ward);
	}
	public void getNurSheet(FileHandling file) throws IOException {
		file.readSheet("nurse");
	}
}
