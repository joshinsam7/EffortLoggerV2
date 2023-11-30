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
import application.Controller.DLCController;
import application.Entity.Defect;
import application.Entity.Effort;
import application.Entity.EffortCategory;
import application.Entity.LifeCycleStep;
import application.Entity.Project;
import application.Util.EffortTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class DLCController implements Initializable{
	@FXML private ChoiceBox<String> projectChoiceBox;
	@FXML private ChoiceBox<String> defectChoiceBox;
	@FXML private ChoiceBox<String> ECChoiceBox;
	@FXML private Label statusLabel;
		
	@FXML private Button createBtn;
	@FXML private TextField defectNameTextField;
	@FXML private TextField defectSCTextField;
		
	ObservableList<Project> listP;
	ObservableList<Defect> listD;
    
	Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
        
    @FXML
    private void createBtnClicked(ActionEvent event) {
    	conn = mysqlconnect.ConnectDb();
        String sql = "insert into defect_table (Name,Detail,Status)values(?,?,?)";                        
        
        try {
            pst = conn.prepareStatement(sql);            
            pst.setString(1, defectNameTextField.getText().toString());
            pst.setString(2, defectSCTextField.getText().toString());
            pst.setInt(3, 1);           
            pst.execute();
            updateDefectChoiceBox();
//            timer.reset();
//            timeLabel.setText("");
//        	infoLabel.setText("Submitted!");
//            infoLabel.setTextFill(Color.GREEN);      

        } catch (Exception e) {       
        	System.out.print(e.getMessage());
        }    	    	    	
    }
    	    
    public void updateProjectChoiceBox(){        
             		        
     	//load data from MySQL
    	listP = mysqlconnect.getProjects();
    	List<String> projectChoices = listP.stream()
                .map(project -> project.getName()) // get each project's name
                .collect(Collectors.toList());
        projectChoiceBox.getItems().addAll(projectChoices);
    }        
    
    public void updateDefectChoiceBox(){        
        
    	//load data from MySQL
    	listD = mysqlconnect.getDefects();
    	List<String> defectChoices = listD.stream()
                .map(defect -> defect.getName()) // get each defect's name
                .collect(Collectors.toList());
        defectChoiceBox.getItems().addAll(defectChoices);
    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateProjectChoiceBox();
		updateDefectChoiceBox();
		defectChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {                
            	if(newValue != null) {
            		Defect d = mysqlconnect.getOneDefect(newValue);
            		defectNameTextField.setText(d.getName());                	
                	defectSCTextField.setText(d.getDetail());
                	statusLabel.setText(d.isStatus()?"Status: Open":"Status: Closed");
            	}            	            	                
            }
        });
	}
}
