package application.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.Database.mysqlconnect;
import application.Entity.Effort;
import application.Entity.EffortCategory;
import application.Entity.LifeCycleStep;
import application.Entity.Project;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class LogsController implements Initializable{
	
	@FXML private TableView<Effort> logTableView;
	@FXML private TableColumn<Effort, Integer> IDColumn;
	@FXML private TableColumn<Effort, Date> DateColumn;
	@FXML private TableColumn<Effort, Time> StartColumn;
	@FXML private TableColumn<Effort, Time> StopColumn;
	@FXML private TableColumn<Effort, Double> TimeColumn;
	@FXML private TableColumn<Effort, Integer> LCSColumn;
	@FXML private TableColumn<Effort, Integer> ECColumn;
	@FXML private TableColumn<Effort, Integer> DIColumn;
			
	ObservableList<Effort> listE;
	
//	ObservableList<LifeCycleStep> listLCS;
	   
	Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void updateLogTable(){        
        
    	// Set up the columns in the table
     	IDColumn.setCellValueFactory(new PropertyValueFactory<Effort, Integer>("ID"));
     	DateColumn.setCellValueFactory(new PropertyValueFactory<Effort, Date>("date"));
     	StartColumn.setCellValueFactory(new PropertyValueFactory<Effort, Time>("start"));
     	StopColumn.setCellValueFactory(new PropertyValueFactory<Effort, Time>("stop"));
     	TimeColumn.setCellValueFactory(new PropertyValueFactory<Effort, Double>("time"));
     	LCSColumn.setCellValueFactory(new PropertyValueFactory<Effort, Integer>("LCS"));
     	ECColumn.setCellValueFactory(new PropertyValueFactory<Effort, Integer>("EC"));
     	DIColumn.setCellValueFactory(new PropertyValueFactory<Effort, Integer>("DI"));
     		 
     	IDColumn.setResizable(false);
     	DateColumn.setResizable(false);
     	StartColumn.setResizable(false);
        StopColumn.setResizable(false);
        TimeColumn.setResizable(false);
        LCSColumn.setResizable(false);
        ECColumn.setResizable(false);
        DIColumn.setResizable(false);
        
     	//load data from MySQL
        listE = mysqlconnect.getEfforts();
        logTableView.setItems(listE);
    }
    

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateLogTable();
	}
	
	
}
