import java.util.Scanner;
public class Person {
	private String full_name, gender, id, address;
	private String phone;
	public Person() {
	}
//	public Person(String id) {
//		this.id = id;
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter Full Name: ");
//		this.full_name = input.nextLine();
//		System.out.println("Enter Address: ");
//		this.address = input.nextLine();
//		System.out.println("Enter Gender: ");
//		this.gender = input.nextLine();
//		System.out.println("Enter Phone Number: ");
//		this.phone = input.nextInt();
//	}
	public Person ( String id, String full_name, String gender, String address, String phone) {
		this.full_name = full_name;
		this.gender = gender;
		this.id = id;
		this.address = address;
		this.phone = phone;
	}
	public void addPerson (String id, String full_name, String gender, String address, String phone){
		this.full_name = full_name;
		this.gender = gender;
		this.id = id;
		this.address = address;
		this.phone = phone;
	}
	public String toString() {
		return "ID: " + id + "\tFname: " + full_name + "\taddress: " + 
	address + "\tPhone Number: " + phone + "\tGender: " + gender + "\t";
	}
	
}