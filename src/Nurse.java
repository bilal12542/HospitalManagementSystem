import java.util.ArrayList;
import java.util.Scanner;

public class Nurse extends Person{
	private String department;
	ArrayList<Integer> Ward = new ArrayList<Integer>();
	Nurse(int id, String department){
		super();
		Scanner input = new Scanner(System.in);
		this.department = input.nextLine();
	}
	public void addWard(int room) {
		Ward.add(room);
	}
	public void removeWard(int room) {
		if (Ward.contains(room)) {
			Ward.remove(Ward.indexOf(room));
		} else {
			System.out.println("Ward doesn't exist.");
		}
	}
	public String toString() {
		return super.toString() + "Department: " + this.department + "\nWards: "
				+ this.Ward;
	}
}
