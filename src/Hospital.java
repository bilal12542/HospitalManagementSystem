import java.util.Scanner;

public class Hospital {
	private int id;
	private String address, hospital_name, phone;
	Hospital (){
	}
	public void newHospital(int id, String address, String hospital_name, String phone){
		Scanner input = new Scanner(System.in);
		this.id = input.nextInt();
		this.hospital_name = input.nextLine();
		this.address = input.nextLine();
	}
	public String toString() {
		return "ID: " + this.id + "\tHospital Name: " + this.hospital_name + "\t"
				+ "\tAddress: " + this.address + "\tPhone# " + this.phone;
	}
}
	