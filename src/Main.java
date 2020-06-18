

public class Main {
	
	public static void main(String[] args) throws Exception {
		FileHandling file = new FileHandling("hospital1.xlsx");
//		Doctor doc = new Doctor(file);
//		doc.newDoctor(file);
//		Staff staff = new Staff(file);
		Medicine Meds = new Medicine(file);
		Meds.newMed(file);
//		staff.newStaff(file);
		Meds.viewAllMeds();
//		staff.newStaff(file);
//		staff.viewAllStaff();
	}
}