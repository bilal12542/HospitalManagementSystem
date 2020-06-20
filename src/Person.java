import org.apache.poi.ss.usermodel.Row;
public class Person {
	private String full_name, gender, id, address;
	private String phone;
	public Person() {
	}
	public Person ( String id, String full_name, String gender, String address, String phone) {
		this.full_name = full_name;
		this.gender = gender;
		this.id = id;
		this.address = address;
		this.phone = phone;
	}
	public void addPerson (Row row, String id, String full_name, String gender, String address, String phone){
		row.getCell(1).setCellValue(full_name);
		row.getCell(2).setCellValue(gender);
		row.getCell(0).setCellValue(id);
		row.getCell(4).setCellValue(address);
		row.getCell(3).setCellValue(phone);
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String toString() {
		return "ID: " + getId() + "\tFname: " + getFull_name() + "\taddress: " + 
	getAddress() + "\tPhone Number: " + getPhone() + "\tGender: " + getGender() + "\t";
	}
	
}