package application.Entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Project {  
	
	private int ID;
	private SimpleStringProperty name;
	private SimpleIntegerProperty LCS1, LCS2, LCS3, LCS4, LCS5, LCS6, LCS7, LCS8, LCS9, LCS10, LCS11, LCS12, LCS13, LCS14, LCS15, LCS16, LCS17, LCS18, LCS19, LCS20, LCS21, LCS22, LCS23, LCS24, LCS25;
	
	
	
	public Project(int iD, String name) {
		super();
		ID = iD;		
		this.name = new SimpleStringProperty(name);
	}
	
	public Project(int iD, String name, int lCS1) {
		super();
		ID = iD;		
		this.name = new SimpleStringProperty(name);
		this.LCS1 = new SimpleIntegerProperty(lCS1);
	}

	public Project(int iD, SimpleStringProperty name, SimpleIntegerProperty lCS1, SimpleIntegerProperty lCS2,
			SimpleIntegerProperty lCS3, SimpleIntegerProperty lCS4, SimpleIntegerProperty lCS5,
			SimpleIntegerProperty lCS6, SimpleIntegerProperty lCS7, SimpleIntegerProperty lCS8,
			SimpleIntegerProperty lCS9, SimpleIntegerProperty lCS10, SimpleIntegerProperty lCS11,
			SimpleIntegerProperty lCS12, SimpleIntegerProperty lCS13, SimpleIntegerProperty lCS14,
			SimpleIntegerProperty lCS15, SimpleIntegerProperty lCS16, SimpleIntegerProperty lCS17,
			SimpleIntegerProperty lCS18, SimpleIntegerProperty lCS19, SimpleIntegerProperty lCS20,
			SimpleIntegerProperty lCS21, SimpleIntegerProperty lCS22, SimpleIntegerProperty lCS23,
			SimpleIntegerProperty lCS24, SimpleIntegerProperty lCS25) {
		super();
		ID = iD;
		this.name = name;
		LCS1 = lCS1;
		LCS2 = lCS2;
		LCS3 = lCS3;
		LCS4 = lCS4;
		LCS5 = lCS5;
		LCS6 = lCS6;
		LCS7 = lCS7;
		LCS8 = lCS8;
		LCS9 = lCS9;
		LCS10 = lCS10;
		LCS11 = lCS11;
		LCS12 = lCS12;
		LCS13 = lCS13;
		LCS14 = lCS14;
		LCS15 = lCS15;
		LCS16 = lCS16;
		LCS17 = lCS17;
		LCS18 = lCS18;
		LCS19 = lCS19;
		LCS20 = lCS20;
		LCS21 = lCS21;
		LCS22 = lCS22;
		LCS23 = lCS23;
		LCS24 = lCS24;
		LCS25 = lCS25;
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

	public int getLCS1() {
		return LCS1.get();
	}

	public void setLCS1(SimpleIntegerProperty lCS1) {
		LCS1 = lCS1;
	}

	public SimpleIntegerProperty getLCS2() {
		return LCS2;
	}

	public void setLCS2(SimpleIntegerProperty lCS2) {
		LCS2 = lCS2;
	}

	public SimpleIntegerProperty getLCS3() {
		return LCS3;
	}

	public void setLCS3(SimpleIntegerProperty lCS3) {
		LCS3 = lCS3;
	}

	public SimpleIntegerProperty getLCS4() {
		return LCS4;
	}

	public void setLCS4(SimpleIntegerProperty lCS4) {
		LCS4 = lCS4;
	}

	public SimpleIntegerProperty getLCS5() {
		return LCS5;
	}

	public void setLCS5(SimpleIntegerProperty lCS5) {
		LCS5 = lCS5;
	}

	public SimpleIntegerProperty getLCS6() {
		return LCS6;
	}

	public void setLCS6(SimpleIntegerProperty lCS6) {
		LCS6 = lCS6;
	}

	public SimpleIntegerProperty getLCS7() {
		return LCS7;
	}

	public void setLCS7(SimpleIntegerProperty lCS7) {
		LCS7 = lCS7;
	}

	public SimpleIntegerProperty getLCS8() {
		return LCS8;
	}

	public void setLCS8(SimpleIntegerProperty lCS8) {
		LCS8 = lCS8;
	}

	public SimpleIntegerProperty getLCS9() {
		return LCS9;
	}

	public void setLCS9(SimpleIntegerProperty lCS9) {
		LCS9 = lCS9;
	}

	public SimpleIntegerProperty getLCS10() {
		return LCS10;
	}

	public void setLCS10(SimpleIntegerProperty lCS10) {
		LCS10 = lCS10;
	}

	public SimpleIntegerProperty getLCS11() {
		return LCS11;
	}

	public void setLCS11(SimpleIntegerProperty lCS11) {
		LCS11 = lCS11;
	}

	public SimpleIntegerProperty getLCS12() {
		return LCS12;
	}

	public void setLCS12(SimpleIntegerProperty lCS12) {
		LCS12 = lCS12;
	}

	public SimpleIntegerProperty getLCS13() {
		return LCS13;
	}

	public void setLCS13(SimpleIntegerProperty lCS13) {
		LCS13 = lCS13;
	}

	public SimpleIntegerProperty getLCS14() {
		return LCS14;
	}

	public void setLCS14(SimpleIntegerProperty lCS14) {
		LCS14 = lCS14;
	}

	public SimpleIntegerProperty getLCS15() {
		return LCS15;
	}

	public void setLCS15(SimpleIntegerProperty lCS15) {
		LCS15 = lCS15;
	}

	public SimpleIntegerProperty getLCS16() {
		return LCS16;
	}

	public void setLCS16(SimpleIntegerProperty lCS16) {
		LCS16 = lCS16;
	}

	public SimpleIntegerProperty getLCS17() {
		return LCS17;
	}

	public void setLCS17(SimpleIntegerProperty lCS17) {
		LCS17 = lCS17;
	}

	public SimpleIntegerProperty getLCS18() {
		return LCS18;
	}

	public void setLCS18(SimpleIntegerProperty lCS18) {
		LCS18 = lCS18;
	}

	public SimpleIntegerProperty getLCS19() {
		return LCS19;
	}

	public void setLCS19(SimpleIntegerProperty lCS19) {
		LCS19 = lCS19;
	}

	public SimpleIntegerProperty getLCS20() {
		return LCS20;
	}

	public void setLCS20(SimpleIntegerProperty lCS20) {
		LCS20 = lCS20;
	}

	public SimpleIntegerProperty getLCS21() {
		return LCS21;
	}

	public void setLCS21(SimpleIntegerProperty lCS21) {
		LCS21 = lCS21;
	}

	public SimpleIntegerProperty getLCS22() {
		return LCS22;
	}

	public void setLCS22(SimpleIntegerProperty lCS22) {
		LCS22 = lCS22;
	}

	public SimpleIntegerProperty getLCS23() {
		return LCS23;
	}

	public void setLCS23(SimpleIntegerProperty lCS23) {
		LCS23 = lCS23;
	}

	public SimpleIntegerProperty getLCS24() {
		return LCS24;
	}

	public void setLCS24(SimpleIntegerProperty lCS24) {
		LCS24 = lCS24;
	}

	public SimpleIntegerProperty getLCS25() {
		return LCS25;
	}

	public void setLCS25(SimpleIntegerProperty lCS25) {
		LCS25 = lCS25;
	}	
}