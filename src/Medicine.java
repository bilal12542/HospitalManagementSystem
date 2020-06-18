import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Medicine{
	private String med_name, med_comp, exp_date;
	private int med_cost, count;
	ArrayList<Medicine> arrMeds;
	public Medicine(FileHandling file) throws IOException {
		super();
		getMedSheet(file);
		addAllMedObj(file);
	}
    public Medicine(String med_name ,String med_comp,String exp_date , int med_cost, int count) {
    	this.med_name = med_name;
    	this.med_comp = med_comp;
    	this.exp_date = exp_date;
    	this.med_cost = med_cost;
    	this.count = count;
    }
    private void addAllMedObj(FileHandling file) {
    	ArrayList<Medicine> Meds = new ArrayList<Medicine>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			Meds.add(new Medicine( row.getCell(0).getStringCellValue(),
					row.getCell(1).getStringCellValue(),
					row.getCell(2).getStringCellValue(),
					(int) row.getCell(3).getNumericCellValue(),
					(int) row.getCell(4).getNumericCellValue()
					));
		}
		this.arrMeds = Meds;
	}
	private void getMedSheet(FileHandling file) throws IOException {
		file.readSheet("Meds");
		
	}
	
	public void newMed(FileHandling file) throws IOException{
		getMedSheet(file);
		Row row = file.createRowCell(file.lastRow()+1);
		Scanner input = new Scanner(System.in);
        System.out.print("Med Name:");
        this.med_name = input.nextLine();
		row.getCell(0).setCellValue(med_name);
        System.out.print("Med Company:");
        this.med_comp = input.nextLine();
		row.getCell(1).setCellValue(med_comp);

        System.out.print("Expiry date:");
        this.exp_date = input.nextLine();
		row.getCell(2).setCellValue(exp_date);

        System.out.print("Med Cost:");
        this.med_cost = input.nextInt();
		row.getCell(3).setCellValue(med_cost);

        System.out.print("Count:");
        this.count = input.nextInt();
		row.getCell(4).setCellValue(count);

		
		file.writeSheet();
		addAllMedObj(file);
    }
	public void viewAllMeds() {
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Meds - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		for(int i = 0; i<arrMeds.size(); i++) {
			this.arrMeds.get(i).printMeds();
		}
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Meds - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		}
    public void printMeds(){
        System.out.println( "Med Name: " + med_name + "\t" + "Med Company: " + med_comp + "\t" + "Expiry date: " + exp_date + "\t" + "Med Cost: " + med_cost + "\t" + "Count: " + count);
    }
}
