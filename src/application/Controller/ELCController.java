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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;


public class ELCController implements Initializable{
	@FXML private ChoiceBox<String> projectChoiceBox;
	@FXML private ChoiceBox<String> LCSChoiceBox;
	@FXML private ChoiceBox<String> ECChoiceBox;
		
	@FXML private Button startBtn;
	@FXML private Button stopBtn;
	@FXML private Button submitBtn;
	@FXML private Label timeLabel;
	@FXML private Label infoLabel;
	EffortTimer timer;
	
	private boolean timerRunning = false;
		
	ObservableList<Project> listP;
	
	ObservableList<LifeCycleStep> listLCS;
	
    ObservableList<EffortCategory> listEC;  
    
	Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

	LocalTime startTime;
	LocalTime stopTime;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    LocalDate currentDate;    
    
    @FXML
    private void submitBtnClicked(ActionEvent event) {
    	conn = mysqlconnect.ConnectDb();
        String sql = "insert into effort_table (Date,Start,Stop,Time,LCS,EC,DI)values(?,?,?,?,?,?,?)";
        
        currentDate = LocalDate.now();
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, currentDate.toString());
            pst.setString(2, startTime.format(formatter));
            pst.setString(3, stopTime.format(formatter));
            pst.setString(4, String.valueOf(timer.getDuration()));
            pst.setString(5, "1");
            pst.setString(6, "3");
            pst.setString(7, "5");
            pst.execute();
            timer.reset();
            timeLabel.setText("");
        	infoLabel.setText("Submitted!");
            infoLabel.setTextFill(Color.GREEN);
            mysqlconnect.getEfforts();
        } catch (Exception e) {            
        }    	    	    	
    }
    
    @FXML
    private void startBtnClicked(ActionEvent event) {
        if (!timerRunning) {
        	infoLabel.setText("Clock is running!");
        	infoLabel.setTextFill(Color.GREEN);
            startTime = LocalTime.now();
        	timer.start();
            timerRunning = true;
            stopBtn.setDisable(false); // Enable the stop button
            startBtn.setDisable(true); // Disable the start button
        }
    }
	
	@FXML
    private void stopBtnClicked(ActionEvent event) {
		stopTime = LocalTime.now();
		infoLabel.setText("Clock has stopped!");
		infoLabel.setTextFill(Color.RED);
		timer.stop();
        timer.pause();
        timerRunning = false;
        stopBtn.setDisable(true); // Disable the stop button
        startBtn.setDisable(false); // Enable the start button
    }
    
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
		timer = new EffortTimer(timeLabel);		
	}
}
