package application.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.Database.mysqlconnect;
import application.Entity.Effort;
import application.Entity.EffortCategory;
import application.Entity.LifeCycleStep;
import application.Entity.Project;
import application.Util.EffortTimer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class ELEController implements Initializable{
	
	@FXML private ChoiceBox<String> entryChoiceBox;
	@FXML private DatePicker datePicker;
	@FXML private TextField startTextField;
	@FXML private TextField stopTextField;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					
//	ObservableList<Effort> listE;
	
//	ObservableList<LifeCycleStep> listLCS;
//	
//    ObservableList<EffortCategory> listEC;  
    
	Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;            
    
    public void updateEntryChoiceBox(){        
             		        
     	//load data from MySQL	
    	mysqlconnect.getEffortChoices();    	
    	entryChoiceBox.setItems(mysqlconnect.effortChoices);                      
    }        
    
//    public void updateLCSChoiceBox(){        
//        
//    	//load data from MySQL
//    	listLCS = mysqlconnect.getLCSs();
//    	List<String> LCSChoices = listLCS.stream()
//                .map(LCS -> LCS.getName()) // get each project's name
//                .collect(Collectors.toList());
//        LCSChoiceBox.getItems().addAll(LCSChoices);
//    }
//    
//    public void updateECChoiceBox(){        
//        
//    	//load data from MySQL
//    	listEC = mysqlconnect.getECs();
//    	List<String> ECChoices = listEC.stream()
//                .map(EC -> EC.getName()) // get each project's name
//                .collect(Collectors.toList());
//        ECChoiceBox.getItems().addAll(ECChoices);
//    }  
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateEntryChoiceBox();
		entryChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {                
            	if(newValue != null) {
            		Effort e = mysqlconnect.getOneEffort(newValue.substring(0,newValue.indexOf(' ')));
                	datePicker.setValue(LocalDate.parse(newValue.substring(newValue.indexOf(' ') + 1,newValue.indexOf(' ') + 11), formatter));                	
                	startTextField.setText(String.valueOf(e.getStart()));
                	stopTextField.setText(String.valueOf(e.getStop()));
            	}
            	
            	
                
            }
        });
//		updateLCSChoiceBox();
//		updateECChoiceBox();	
				
	}
}
