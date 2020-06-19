import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;

public class Record {
	private String id, patient_id, date, treatment, sickness, medicines;
	ArrayList<Record> arrRec = new ArrayList<Record>();
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
	public void newDoctor (FileHandling file) throws IOException{
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
	private void addAllRecObj(FileHandling file) {
		ArrayList<Record> rec = new ArrayList<Record>();
		Row row;
		for(int i = 0; i < file.lastRow(); i++) {
			row = file.getRow(i+1);
			
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
	public void viewAllRecc() {
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Record - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		for(int i = 0; i<arrRec.size(); i++) {
			this.arrRec.get(i).printRec();
		}
		System.out.println("X- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Record - - - - - - - - - - - - - "
				+ "- - - - - - - - - - - - - - - - -X");
		}
	public void printRec() {
		System.out.println( "ID: " + id + "\tPatient_ID: " + patient_id + "\tDate: " + date + "\tTreatment: "
				+ treatment + "\tSickness: " + sickness + "\tMedicines: " + medicines);
	}
	public void getRecSheet(FileHandling file) throws IOException {
		file.readSheet("record");
	}
}
