import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;

public class Main {
	
	public static void main(String[] args) throws Exception {
		FileHandling file = new FileHandling("hospital1.xlsx");
		Doctor doc = new Doctor();
		Sheet sh = file.readSheet("doctor", doc);
		doc.newDoctor(sh);
		ArrayList<Doctor> arr = doc.viewAll(sh);
		for(int i = 0; i<arr.size(); i++) {
			arr.get(i).printDoc();
		}
	}
}