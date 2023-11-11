package application.Entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LifeCycleStep {
	
	private int ID;
	private SimpleStringProperty name;
	private SimpleIntegerProperty EC;
	private SimpleIntegerProperty D;
		
	public LifeCycleStep(int iD, String name, int eC, int d) {
		super();
		ID = iD;
		this.name = new SimpleStringProperty(name);
		EC = new SimpleIntegerProperty(eC);
		D = new SimpleIntegerProperty(d);
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

	public int getEC() {
		return EC.get();
	}

	public void setEC(SimpleIntegerProperty eC) {
		EC = eC;
	}

	public int getD() {
		return D.get();
	}

	public void setD(SimpleIntegerProperty d) {
		D = d;
	}
	
	
}

