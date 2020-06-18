

public class Main {
	
	public static void main(String[] args) throws Exception {
		FileHandling file = new FileHandling("hospital1.xlsx");
		Patient Pat = new Patient(file);
		Pat.newPatient(file);
		Pat.viewAllPat();
		
//		Staff staff = new Staff(file);
//		Medicine Meds = new Medicine(file);
		
//		Meds.newMed(file);
//		staff.newStaff(file);
		
//		Meds.viewAllMeds();
//		staff.newStaff(file);
//		staff.viewAllStaff();
	}
}