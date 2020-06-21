import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Record {
	private String id, patient_id, date, treatment, sickness, medicines;
	ArrayList<Record> arrRec = new ArrayList<Record>();
    private ArrayList<Integer> indexes = new ArrayList<Integer>();
    private int searchIndex = 0;
	public Record(FileHandling file) throws IOException {
		getRecSheet(file);
		addAllRecObj(file);
	}
	public Record(String id, String patient_id, String date, String treatment, String sickness, String medicines) {
		this.id = id;
		this.patient_id = patient_id;
		this.date = date;
		this.treatment = treatment;
		this.sickness = sickness;
		this.medicines = medicines;
	}
	public void getRecSheet(FileHandling file) throws IOException {
		file.readSheet("record");
	}
	public void newRecord(FileHandling file) throws IOException{
		getRecSheet(file);
		Scanner input = new Scanner(System.in);
		Row row = file.createRowCell(file.lastRow()+1);
		System.out.println("Enter ID: ");
		this.id = "R-" + input.nextLine();
		row.getCell(0).setCellValue(id);
		System.out.println("Enter Patient_ID: ");
		this.patient_id = input.nextLine();
		row.getCell(1).setCellValue(patient_id);
		System.out.println("Enter Date: ");
		this.date= input.nextLine();
		row.getCell(2).setCellValue(date);
		System.out.println("Enter Treatment: ");
		this.treatment = input.nextLine();
		row.getCell(3).setCellValue(treatment);
		System.out.println("Enter Sickness: ");
		this.sickness = input.nextLine();
		row.getCell(4).setCellValue(sickness);
		System.out.println("Enter Medicines: ");
		this.medicines = input.nextLine(); 
		row.getCell(5).setCellValue(medicines);
		file.writeSheet();
		arrRec.add(new Record(id, patient_id, date, treatment, sickness, medicines));
		input.close();
	}
	public ArrayList<Integer> getIndexes() {
		return indexes;
	}
	public void setIndexes(ArrayList<Integer> indexes) {
		this.indexes = indexes;
	}
	public int getSearchIndex() {
		return searchIndex;
	}
	public void setSearchIndex(int searchIndex) {
		this.searchIndex = searchIndex;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}
	public String getSickness() {
		return sickness;
	}
	public void setSickness(String sickness) {
		this.sickness = sickness;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private void addAllRecObj(FileHandling file) {
		ArrayList<Record> rec = new ArrayList<Record>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			if (row == null) {
				rec.add(new Record("","","","","",""));
			} else {
			rec.add(new Record(row.getCell(0).getStringCellValue(),
					row.getCell(1).getStringCellValue(),
					row.getCell(2).getStringCellValue(),
					row.getCell(3).getStringCellValue(),
					row.getCell(4).getStringCellValue(),
					row.getCell(5).getStringCellValue()
					));
		}
		this.arrRec = rec;
	}
	public void removeObj(String str) {
		if (search(str)) {
			arrRec.remove(getSearchIndex());
			viewAllRec();
		} else {
			System.out.println("Input doesn't exist.");
		}
	}
	public boolean search(String str) {
		ArrayList<Record> arr = arrRec;
		for (int i = 0; i < arr.size(); i++) {
			Record find = arr.get(i);
			if(find.getId().equals(str)) {
				setSearchIndex(i); 
				getIndexes().add(i);
				return true;
			}
		}
		return false;
	}
	public void updateRecordSheet(FileHandling file) throws IOException {
		if(indexes.isEmpty()) {
			;
		} else {
		getRecSheet(file);
		file.updateSheet(getIndexes());
		}
	}
	public void viewAllRec() {
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Record - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		for(int i = 0; i<arrRec.size(); i++) {
			this.arrRec.get(i).printRec();
		}
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Record - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
	}
	public void printRec() {
		System.out.println( "ID: " + getId() + "\tPatient_ID: " + getPatient_id() + "\tDate: " + getDate() + "\tTreatment: "
				+ getTreatment() + "\tSickness: " + getSickness() + "\tMedicines: " + getMedicines());
	}
}
