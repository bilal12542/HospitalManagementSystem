import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		FileHandling file = new FileHandling("hospital1.xlsx");
		Scanner sc = new Scanner(System.in);
		Doctor doc = new Doctor(file);
		Nurse nur = new Nurse(file);
		Staff staff = new Staff(file);
		Patient Pat = new Patient(file);
		Medicine Med = new Medicine(file);
		Labs lab = new Labs(file);
		Record rec = new Record(file);
		rec.viewAllRecc();
//		while(true) {
//			System.out.println("For Doctor press '1'");
//			System.out.println("For Nurse press '2'");
//			System.out.println("For Staff press '3'");
//			System.out.println("For Labs press '4'");
//			System.out.println("View All Tables press '5'");
//			switch(sc.nextInt()){
//			case 0:
//				break;
//			case 1:
//				while(true) {
//					System.out.println("View Press '1'");
//					System.out.println("Add Press '2'");
//					System.out.println("Main Menu Press '3'");
//					switch(sc.nextInt()) {
//					case 1:
//						doc.viewAllDoc();
//					case 2:
//						doc.newDoctor(file);
////						doc.viewAllDoc();
//					case 3:
//						break;
//					default:
//						System.out.println("Invalid Option");
//					}
//				}
//			case 5:
//				doc.viewAllDoc();
//				nur.viewAllNurse();
//				staff.viewAllStaff();
//				lab.viewAllLabs();
//			default:
//				System.out.println("Invalid Option");
//			}
//		}
	}
}