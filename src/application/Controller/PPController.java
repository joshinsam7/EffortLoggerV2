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
import application.Controller.ELEController;
import application.Entity.Effort;
import application.Entity.EffortCategory;
import application.Entity.LifeCycleStep;
import application.Entity.Project;
import application.Util.EffortTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;


public class PPController implements Initializable{
	@FXML private ChoiceBox<String> storyChoiceBox;
	@FXML private ChoiceBox<String> LCSChoiceBox;
	@FXML private ChoiceBox<String> descriptionChoiceBox;
		
//	@FXML private Button startBtn;
		
	private boolean timerRunning = false;
		
	ObservableList<Project> listS;
	
	ObservableList<LifeCycleStep> listLCS;
	
    ObservableList<String> listD;  
    
	Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
//    @FXML
//    private void submitBtnClicked(ActionEvent event) {
//    	conn = mysqlconnect.ConnectDb();
//        String sql = "insert into effort_table (Date,Start,Stop,Time,LCS,EC,DI)values(?,?,?,?,?,?,?)";
//        
//        currentDate = LocalDate.now();
//        
//        try {
//            pst = conn.prepareStatement(sql);
//            pst.setString(1, currentDate.toString());
//            pst.setString(2, startTime.format(formatter));
//            pst.setString(3, stopTime.format(formatter));
//            pst.setString(4, String.valueOf(timer.getDuration()));
//            pst.setString(5, "1");
//            pst.setString(6, "3");
//            pst.setString(7, "5");
//            pst.execute();
//            timer.reset();
//            timeLabel.setText("");
//        	infoLabel.setText("Submitted!");
//            infoLabel.setTextFill(Color.GREEN);      
//            mysqlconnect.getEfforts();
//            mysqlconnect.getEffortChoices();
//        } catch (Exception e) {            
//        }    	    	    	
//    }
//    
//    @FXML
//    private void startBtnClicked(ActionEvent event) {
//        if (!timerRunning) {
//        	infoLabel.setText("Clock is running!");
//        	infoLabel.setTextFill(Color.GREEN);
//            startTime = LocalTime.now();
//        	timer.start();
//            timerRunning = true;
//            stopBtn.setDisable(false); // Enable the stop button
//            startBtn.setDisable(true); // Disable the start button
//        }
//    }
//	
//	@FXML
//    private void stopBtnClicked(ActionEvent event) {
//		stopTime = LocalTime.now();
//		infoLabel.setText("Clock has stopped!");
//		infoLabel.setTextFill(Color.RED);
//		timer.stop();
//        timer.pause();
//        timerRunning = false;
//        stopBtn.setDisable(true); // Disable the stop button
//        startBtn.setDisable(false); // Enable the start button
//    }
//    
    public void updateStoryChoiceBox(){        
             		        
     	//load data from MySQL
    	listS = mysqlconnect.getProjects();
    	List<String> projectChoices = listS.stream()
                .map(project -> project.getName()) // get each project's name
                .collect(Collectors.toList());
        storyChoiceBox.getItems().addAll(projectChoices);
    }        
    
    public void updateLCSChoiceBox(){        
        
    	//load data from MySQL
    	listLCS = mysqlconnect.getLCSs();
    	List<String> LCSChoices = listLCS.stream()
                .map(LCS -> LCS.getName()) // get each project's name
                .collect(Collectors.toList());
        LCSChoiceBox.getItems().addAll(LCSChoices);
    }
//    
    public void updateDescriptionChoiceBox(){        
        
    	//load data from MySQL
    	listD = mysqlconnect.getEffortChoices();    	
        descriptionChoiceBox.getItems().addAll(listD);
    }  
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateStoryChoiceBox();
		updateLCSChoiceBox();
		updateDescriptionChoiceBox();	
				
	}
}
