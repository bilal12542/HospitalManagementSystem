

public class Main {
	
	public static void main(String[] args) throws Exception {
		FileHandling file = new FileHandling("hospital1.xlsx");
		Staff staff = new Staff(file);
		Medicine Meds = new Medicine(file);
		Labs lab = new Labs(file);
		Doctor doc = new Doctor(file);
		doc.viewAllDoc();
		lab.viewAllLabs();
		Meds.viewAllMeds();
		staff.viewAllStaff();
	}
}