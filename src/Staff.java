import java.util.Scanner;

public class Staff extends Person{
	int salary;
	String desig;
	public Staff(int sid) {
        super('S' + Integer.toString(sid));
        Scanner input = new Scanner(System.in);
		System.out.println("Salary: ");
        this.salary = input.nextInt();
		System.out.println("Designation: ");
        this.desig = input.nextLine();
	}
	@Override
	public String toString() {
		return super.toString()+ "Designation: " + this.desig
				+ "\nsalary: " + this.salary;
	}
}
