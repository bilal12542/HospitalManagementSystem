import java.util.Scanner;

public class Patient extends Person{
	private String blood_group;
	String registration_date;
	Patient (int id, int registration_date, String blood_group){
		super();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Registration Date: ");
		this.registration_date = input.nextLine();
		System.out.println("Enter Blood Group: ");
		this.blood_group = input.nextLine();	
	}
	public String toString() {
		return super.toString() + "Registration Date: " + this.registration_date
				+ "\nBlood Group: " + this.blood_group ;
	}
}
