package application.Entity;

public class Defect {
	private int ID;
	private String name, detail;
	private boolean status;
	public Defect(int iD, String name, String detail, boolean status) {
		super();
		ID = iD;
		this.name = name;
		this.detail = detail;
		this.status = status;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}