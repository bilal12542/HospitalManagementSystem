import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		FileHandling file = new FileHandling("hospital1.xlsx");
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Doctor doc = new Doctor(file);
		Nurse nur = new Nurse(file);
		Staff staff = new Staff(file);
		Patient Pat = new Patient(file);
		Medicine Med = new Medicine(file);
		Labs lab = new Labs(file);
		Record rec = new Record(file);
		//lab.viewAllLabs();
//		lab.removeObj("covid");
//		lab.updateLab(file);
//		lab.removeObj("Covid-19");
//		lab.viewAllLabs();
//		lab.updateLab(file);
//		lab.removeObj("Covid-19");
		mainloop: while(true) {
			System.out.println("For Doctor press '0'");
			System.out.println("For Doctor press '1'");
			System.out.println("For Nurse press '2'");
			System.out.println("For Staff press '3'");
			System.out.println("For Labs press '4'");

			System.out.println("For Pat press '5'");

			System.out.println("For Med press '6'");
			System.out.println("View All Tables press '8'");
			
			switch(sc.nextInt()){
			case 0:
				break mainloop;
			case 1:
				loop: while(true) {
					System.out.println("View Press '1'");
					System.out.println("Add Press '2'");
					System.out.println("Remove and Update Sheet Press '3'");
					System.out.println("Main Menu Press '4'");
					switch(sc.nextInt()) {
					case 1:
						doc.viewAllDoc();
						break;
					case 2:
						doc.newDoctor(file);
						doc.viewAllDoc();
						break;
					case 3:
						System.out.println("Enter UserId: ");
						String str = sc2.nextLine();
						doc.removeObj(str);
						doc.updateDoctorSheet(file);
						break;
					case 4:
						break loop;
					default:
						System.out.println("Invalid Option");
					}
				}
			break;
			case 2:
				loop: while(true) {
					System.out.println("View Press '1'");
					System.out.println("Add Press '2'");
					System.out.println("Remove and Update Sheet Press '3'");
					System.out.println("Main Menu Press '4'");
					switch(sc.nextInt()) {
					case 1:
						rec.viewAllRec();
						break;
					case 2:
						rec.newRecord(file);
						doc.viewAllDoc();
						break;
					case 3:
						System.out.println("Enter UserId: ");
						String str = sc2.nextLine();
						rec.removeObj(str);
						rec.updateRecordSheet(file);
						break;
					case 4:
						break loop;
					default:
						System.out.println("Invalid Option");
					}
				}
			break;
			case 3:
				loop: while(true) {
					System.out.println("View Press '1'");
					System.out.println("Add Press '2'");
					System.out.println("Remove and Update Sheet Press '3'");
					System.out.println("Main Menu Press '4'");
					switch(sc.nextInt()) {
					case 1:
						nur.viewAllNurse();
						break;
					case 2:
						nur.newNurse(file);
						nur.viewAllNurse();
						break;
					case 3:
						System.out.println("Enter UserId: ");
						String str = sc2.nextLine();
						nur.removeObj(str);
						nur.updateNurseSheet(file);
						break;
					case 4:
						break loop;
					default:
						System.out.println("Invalid Option");
					}
				}
			break;
			case 4:
				loop: while(true) {
					System.out.println("View Press '1'");
					System.out.println("Add Press '2'");
					System.out.println("Remove and Update Sheet Press '3'");
					System.out.println("Main Menu Press '4'");
					switch(sc.nextInt()) {
					case 1:
						lab.viewAllLabs();
						break;
					case 2:
						lab.newLab(file);
						lab.viewAllLabs();
						break;
					case 3:
						System.out.println("Enter test_name: ");
						String str = sc2.nextLine();
						lab.removeObj(str);
						lab.updateLab(file);
						break;
					case 4:
						break loop;
					default:
						System.out.println("Invalid Option");
					}
				}
			break;
			case 5:
				loop: while(true) {
					System.out.println("View Press '1'");
					System.out.println("Add Press '2'");
					System.out.println("Remove and Update Sheet Press '3'");
					System.out.println("Main Menu Press '4'");
					switch(sc.nextInt()) {
					case 1:
						Pat.viewAllPat();
						break;
					case 2:
						Pat.newPatient(file);
						Pat.viewAllPat();
						break;
					case 3:
						System.out.println("Enter user_id: ");
						String str = sc2.nextLine();
						Pat.removeObj(str);
						Pat.updatePatientSheet(file);
						break;
					case 4:
						break loop;
					default:
						System.out.println("Invalid Option");
					}
				}
			break;

			case 6:
				loop: while(true) {
					System.out.println("View Press '1'");
					System.out.println("Add Press '2'");
					System.out.println("Remove and Update Sheet Press '3'");
					System.out.println("Main Menu Press '4'");
					switch(sc.nextInt()) {
					case 1:
						Pat.viewAllPat();
						break;
					case 2:
						Med.newMed(file);
						Med.viewAllMeds();
						break;
					case 3:
						System.out.println("Enter user_id: ");
						String str = sc2.nextLine();
						Med.removeObj(str);
						Med.updateMedSheet(file);
						break;
					case 4:
						break loop;
					default:
						System.out.println("Invalid Option");
					}
				}
			break;
			case 8:
				doc.viewAllDoc();
				nur.viewAllNurse();
				staff.viewAllStaff();
				lab.viewAllLabs();
				Pat.viewAllPat();

				Med.viewAllMeds();

				break;
			default:
				System.out.println("Invalid Option");
			}
		}
		sc.close();
	}
}