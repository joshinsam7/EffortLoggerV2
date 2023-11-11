package application.Entity;

import javafx.beans.property.SimpleStringProperty;

public class EffortCategory {
	private int ID;
	private SimpleStringProperty name;
	
	public EffortCategory(int iD, String name) {
		super();
		ID = iD;
		this.name = new SimpleStringProperty(name);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name.get();
	}

	public void setName(SimpleStringProperty name) {
		this.name = name;
	}
}
