import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws Exception {
		FileHandling file = new FileHandling("hospital1.xlsx");
		Doctor doc = new Doctor(file);
//		doc.newDoctor(file);
		doc.viewAll();
		System.out.print(doc.arrDoc.get(1));
	}
}