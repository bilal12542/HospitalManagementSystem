
public class Main {

	public static void main(String[] args) throws Exception {
		FileHandling file = new FileHandling("hospital1.xlsx");
		file.readSheet("hospital");
	}
}