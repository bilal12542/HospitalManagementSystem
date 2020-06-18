import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

Public class Medicine{
	private String med_name, med_comp, exp_date;
	private Int med_cost, count;
	ArrayList<Doctor> arrMeds;
	public Medicine(FileHandling file) throws IOException {
		super();
		getMedSheet(file);
		addAllMedObj(file);
	}
    public Labs(String med_name, med_comp, exp_date , int med_cost, count ) {
    	this.med_name = med_name;
    	this.med_comp = med_comp;
    	this.exp_date = exp_date;
    	this.med_cost = med_cost;
    	this.count = count;
    }
    private void addAllMedObj(FileHandling file) {
    	ArrayList<Meds> Meds = new ArrayList<Meds>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			Meds.add(new Meds( row.getCell(0).getStringCellValue(),
					row.getCell(1).getStringCellValue()
					row.getCell(2).getStringCellValue()
					(int) row.getCell(3).getNumericCellValue()
					(int) row.getCell(4).getNumericCellValue()
					));
		}
		this.arrMeds = Meds;
	}
	private void getMedSheet(FileHandling file) throws IOException {
		file.readSheet("Meds");
		
	}
	
	public void newLab(FileHandling file) throws IOException{
		getMedSheet(file);
		Row row = file.createRowCell(file.lastRow()+1);
        Scanner input = new Scanner(System.in);
        
        System.out.print("Med Name:");
        this.med_name = input.nextLine();
		row.getCell(0).setCellValue(med_name);
		
        System.out.print("Med Company:");
        this.med_comp = input.nextInt();
		row.getCell(1).setCellValue(med_comp);

        System.out.print("Expiry date:");
        this.exp_date = input.nextInt();
		row.getCell(2).setCellValue(exp_date);

        System.out.print("Med Cost:");
        this.med_cost = input.nextInt();
		row.getCell(3).setCellValue(med_cost);

        System.out.print("Count:");
        this.Count = input.nextInt();
		row.getCell(4).setCellValue(Count);

		
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
    public void printLabs(){
        System.out.println( "Med Name: " + med_name + "\t" + "Med Company: " + med_comp + "\t" + "Expiry date: " + exp_date + "\t" + "Med Cost: " + med_cost + "\t" + "Count: " + count);
    }
}
