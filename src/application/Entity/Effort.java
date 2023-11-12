package application.Entity;

import java.sql.Date;
import java.sql.Time;

public class Effort {
	private int ID, LCS, EC, DI;
	private Date date;
	private Time start, stop;
	private double time;
	
	public Effort(int iD, Date date, Time start, Time stop, double time, int lCS, int eC, int dI) {
		super();
		ID = iD;
		LCS = lCS;
		EC = eC;
		DI = dI;
		this.date = date;
		this.start = start;
		this.stop = stop;
		this.time = time;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getLCS() {
		return LCS;
	}

	public void setLCS(int lCS) {
		LCS = lCS;
	}

	public int getEC() {
		return EC;
	}

	public void setEC(int eC) {
		EC = eC;
	}

	public int getDI() {
		return DI;
	}

	public void setDI(int dI) {
		DI = dI;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Time getStop() {
		return stop;
	}

	public void setStop(Time stop) {
		this.stop = stop;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "" + this.ID + " " + this.date + " (" + this.start + "-" + this.stop + ")";
		
	}
	
	
}
