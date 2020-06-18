

public class Main {
	
	public static void main(String[] args) throws Exception {
		FileHandling file = new FileHandling("hospital1.xlsx");
//		Doctor doc = new Doctor(file);
//		doc.newDoctor(file);
//		Staff staff = new Staff(file);
		Meds Med = new Meds(file);
		Med.newMed(file);
//		staff.newStaff(file);
		Med.viewAllMeds();
//		staff.newStaff(file);
//		staff.viewAllStaff();
	}
}