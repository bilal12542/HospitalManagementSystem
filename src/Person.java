import java.util.Scanner;
public class Person {
	private String full_name, gender, id, address;
	private int phone;
	public Person (String id){
		this.id = id;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Full Name: ");
		this.full_name = input.nextLine();
		System.out.println("Enter Address: ");
		this.address = input.nextLine();
		System.out.println("Enter Gender: ");
		this.gender = input.nextLine();
		System.out.println("Enter Phone Number: ");
		this.phone = input.nextInt();
	}
	public String toString() {
		return "ID: " + this.id + "\nFname: " + this.full_name + "\naddress: " + 
	this.address + "\nPhone Number: " + "\nGender: " + this.gender 
	+ this.phone + "\n";
	}
	
}