import java.util.ArrayList;
import java.util.Scanner;

public class Nurse extends Person{
	private String department;
	ArrayList<Ward> Ward = new ArrayList<Ward>();
	Nurse(int id, String department){
		super('N' + Integer.toString(id));
		Scanner input = new Scanner(System.in);
		this.department = input.nextLine();
	}
}
