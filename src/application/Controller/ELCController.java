package application.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.Database.mysqlconnect;
import application.Entity.EffortCategory;
import application.Entity.LifeCycleStep;
import application.Entity.Project;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;


public class ELCController implements Initializable{
	@FXML private ChoiceBox<String> projectChoiceBox;
	@FXML private ChoiceBox<String> LCSChoiceBox;
	@FXML private ChoiceBox<String> ECChoiceBox;
			
	ObservableList<Project> listP;
	
	ObservableList<LifeCycleStep> listLCS;
	
    ObservableList<EffortCategory> listEC;  
    
	Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void updateProjectChoiceBox(){        
             		        
     	//load data from MySQL
    	listP = mysqlconnect.getProjects();
    	List<String> projectChoices = listP.stream()
                .map(project -> project.getName()) // get each project's name
                .collect(Collectors.toList());
        projectChoiceBox.getItems().addAll(projectChoices);
    }        
    
    public void updateLCSChoiceBox(){        
        
    	//load data from MySQL
    	listLCS = mysqlconnect.getLCSs();
    	List<String> LCSChoices = listLCS.stream()
                .map(LCS -> LCS.getName()) // get each project's name
                .collect(Collectors.toList());
        LCSChoiceBox.getItems().addAll(LCSChoices);
    }
    
    public void updateECChoiceBox(){        
        
    	//load data from MySQL
    	listEC = mysqlconnect.getECs();
    	List<String> ECChoices = listEC.stream()
                .map(EC -> EC.getName()) // get each project's name
                .collect(Collectors.toList());
        ECChoiceBox.getItems().addAll(ECChoices);
    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateProjectChoiceBox();
		updateLCSChoiceBox();
		updateECChoiceBox();
	}
	
	
}
