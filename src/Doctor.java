import java.util.Scanner;

public class Doctor extends Person{
	private String specialization, department;
	private int room;
	Doctor (int id){
		super('D' + Integer.toString(id));
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Specialization: ");
		this.specialization = input.nextLine(); 
		System.out.println("Enter Department: ");
		this.department = input.nextLine();
		System.out.println("Enter Room: ");
		this.room = input.nextInt();
	}
	@Override
	public String toString() {
		return super.toString() + "Department: " + this.department + "\nRoom: "
				+ this.room + "\nSpecialization: " + this.specialization;
	}
}


