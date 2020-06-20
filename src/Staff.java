import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Staff extends Person{
	private int salary;
	private String desig, id, full_name, gender, address, phone;
	ArrayList<Staff> arrStaff;
	public Staff(FileHandling file) throws IOException {
		super();
		getStaffSheet(file);
		addAllStaffObj(file);
	}
	public Staff(String id, String full_name, String gender, String phone, String address, 
			String desig, int salary) {
        super(id, full_name, gender, address, phone);
        this.salary = salary;
        this.desig = desig;
	}
	public void getStaffSheet(FileHandling file) throws IOException {
		file.readSheet("staff");
	}
	public void newStaff (FileHandling file) throws IOException{
		getStaffSheet(file);
		Scanner input = new Scanner(System.in);
		int i =  file.lastRow();
		Row row = file.createRowCell(i+1);
		System.out.println("Enter ID: ");
		id = "S-" + input.nextLine();
		System.out.println("Enter Full Name: ");
		full_name = input.nextLine();
		System.out.println("Enter Address: ");
		address = input.nextLine();
		System.out.println("Enter Gender: ");
		gender = input.nextLine();
		System.out.println("Enter Phone Number: ");
		phone = input.nextLine();
		System.out.println("Enter Designation: ");
		this.desig = input.nextLine(); 
		row.getCell(6).setCellValue(desig);
		System.out.println("Enter Salary: ");
		this.salary = input.nextInt();
		row.getCell(5).setCellValue(salary);
		super.addPerson(row, id, full_name, gender, address, phone);
		file.writeSheet();
		arrStaff.add(new Staff(id, full_name, gender, phone, address, desig, salary));
		input.close();
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private void addAllStaffObj(FileHandling file) {
		ArrayList<Staff> staff = new ArrayList<Staff>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			staff.add(new Staff(row.getCell(0).getStringCellValue(),
					row.getCell(1).getStringCellValue(),
					row.getCell(2).getStringCellValue(),
					row.getCell(3).getStringCellValue(),
					row.getCell(4).getStringCellValue(),
					row.getCell(6).getStringCellValue(),
					(int) row.getCell(5).getNumericCellValue()
					));
		}
		this.arrStaff = staff;
	}
	public void viewAllStaff() {
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Staffs - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		for(int i = 0; i<arrStaff.size(); i++) {
			this.arrStaff.get(i).printStaff();
		}
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Staffs - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
	}
	public void printStaff() {
		System.out.println(super.toString()+ "Designation: " + getDesig()
				+ "\tsalary: " + getSalary());
	}
}
