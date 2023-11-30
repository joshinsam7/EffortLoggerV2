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
import application.Entity.Defect;
import application.Entity.Effort;
import application.Entity.EffortCategory;
import application.Entity.LifeCycleStep;
import application.Entity.Project;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.beans.property.SimpleStringProperty;

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
	
	@FXML private TableView<Defect> defectLogTableView;
	@FXML private TableColumn<Defect, Integer> dIDColumn;
	@FXML private TableColumn<Defect, String> dNameColumn;
	@FXML private TableColumn<Defect, String> dDetailColumn;
	@FXML private TableColumn<Defect, Boolean> dStatusColumn;
			
//	public static ObservableList<Effort> listE = FXCollections.observableArrayList();
	
	ObservableList<Defect> listD;
	   
	Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void updateEffectLogTable(){        
        
    	// Set up the columns in the table
     	IDColumn.setCellValueFactory(new PropertyValueFactory<Effort, Integer>("ID"));
     	DateColumn.setCellValueFactory(new PropertyValueFactory<Effort, Date>("date"));
     	StartColumn.setCellValueFactory(new PropertyValueFactory<Effort, Time>("start"));
     	StopColumn.setCellValueFactory(new PropertyValueFactory<Effort, Time>("stop"));
     	TimeColumn.setCellValueFactory(new PropertyValueFactory<Effort, Double>("time"));
     	LCSColumn.setCellValueFactory(new PropertyValueFactory<Effort, Integer>("LCS"));
     	ECColumn.setCellValueFactory(new PropertyValueFactory<Effort, Integer>("EC"));
     	DIColumn.setCellValueFactory(new PropertyValueFactory<Effort, Integer>("DI"));
     		         
     	//load data from MySQL
        mysqlconnect.getEfforts();      
        logTableView.setItems(mysqlconnect.listE);
    }
    
    public void updateDefectLogTable(){        
        
    	// Set up the columns in the table
     	dIDColumn.setCellValueFactory(new PropertyValueFactory<Defect, Integer>("ID"));
     	dNameColumn.setCellValueFactory(new PropertyValueFactory<Defect, String>("name"));
     	dDetailColumn.setCellValueFactory(new PropertyValueFactory<Defect, String>("detail"));
//     	dStatusColumn.setCellValueFactory(new PropertyValueFactory<Defect, Boolean>("status"));
     	dStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        dStatusColumn.setCellFactory(column -> getBooleanCell());
     		         
     	//load data from MySQL
        mysqlconnect.getDefects();
        defectLogTableView.setItems(mysqlconnect.listD);
    }
    
    private TableCell<Defect, Boolean> getBooleanCell() {
        return new TableCell<Defect, Boolean>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item ? "Opened" : "Closed");
                }
            }
        };
    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateEffectLogTable();
		updateDefectLogTable();
	}			
}
