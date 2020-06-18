

public class Main {
	
	public static void main(String[] args) throws Exception {
		FileHandling file = new FileHandling("hospital1.xlsx");
		Doctor doc = new Doctor(file);
//		doc.newDoctor(file);
		Staff staff = new Staff(file);
		Labs lab = new Labs(file);
//		lab.newLab(file);
		staff.newStaff(file);
		lab.viewAllLabs();
//		staff.newStaff(file);
		staff.viewAllStaff();
	}
}