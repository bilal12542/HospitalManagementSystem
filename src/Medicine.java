import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Medicine{
	private String med_name, med_comp, exp_date;
	private int med_cost, count;
	ArrayList<Medicine> arrMeds;    
	private ArrayList<Integer> indexes = new ArrayList<Integer>();
    private int searchIndex = 0;
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
	private void getMedSheet(FileHandling file) throws IOException {
		file.readSheet("meds");
		
	}
	
	public void newMed(FileHandling file) throws IOException{
		getMedSheet(file);
		Row row = file.createRowCell(file.lastRow()+1);
		Scanner input = new Scanner(System.in);
        System.out.print("Med Name:");
        this.med_name = input.nextLine();
		row.getCell(0).setCellValue(med_name);
        System.out.print("Med Company:");
        this.setMed_comp(input.nextLine());
		row.getCell(1).setCellValue(getMed_comp());

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
		arrMeds.add(new Medicine(med_name, getMed_comp(), exp_date, med_cost, count));
		
		input.close();
    }
    public int getSearchIndex() {
		return searchIndex;
	}
	public void setSearchIndex(int searchIndex) {
		this.searchIndex = searchIndex;
	}
	public ArrayList<Integer> getIndexes() {
		return indexes;
	}
	public void setIndexes(ArrayList<Integer> indexes) {
		this.indexes = indexes;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMed_cost() {
		return med_cost;
	}
	public void setMed_cost(int med_cost) {
		this.med_cost = med_cost;
	}
	public String getExp_date() {
		return exp_date;
	}
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	public String getMed_comp() {
		return med_comp;
	}
	public void setMed_comp(String med_comp) {
		this.med_comp = med_comp;
	}
	public String getMed_name() {
		return med_name;
	}
	public void setMed_name(String med_name) {
		this.med_name = med_name;
	}
	private void addAllMedObj(FileHandling file) {
    	ArrayList<Medicine> Meds = new ArrayList<Medicine>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			if (row == null) {
				Meds.add(new Medicine("","","",0,0));
			} else {
				Meds.add(new Medicine( row.getCell(0).getStringCellValue(),
					row.getCell(1).getStringCellValue(),
					row.getCell(2).getStringCellValue(),
					(int) row.getCell(3).getNumericCellValue(),
					(int) row.getCell(4).getNumericCellValue()
					));
		}}
		this.arrMeds = Meds;
	}
	public void removeObj(String str) {
		if (search(str)) {
			arrMeds.remove(getSearchIndex());
			viewAllMeds();
		} else {
			System.out.println("Input doesn't exist.");
		}
	}
	public boolean search(String str) {
		ArrayList<Medicine> arr = arrMeds;
		for (int i = 0; i < arr.size(); i++) {
			Medicine find = arr.get(i);
			if(find.getMed_name().equals(str)) {
				setSearchIndex(i); 
				getIndexes().add(i);
				return true;
			}
		}
		return false;
	}
	public void updateMedSheet(FileHandling file) throws IOException {
		if(indexes.isEmpty()) {
			;
		} else {
		getMedSheet(file);
		file.updateSheet(getIndexes());
		}
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
        System.out.println( "Med Name: " + getMed_name() + "\t" + "Med Company: " + getMed_comp() + 
        		"\t" + "Expiry date: " + getExp_date() + "\t" + "Med Cost: " + getMed_cost() + "\t" + "Count: " + getCount());
    }
}
