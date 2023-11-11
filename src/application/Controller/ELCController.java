package application.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import application.Database.mysqlconnect;
import application.Entity.LifeCycleStep;
import application.Entity.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ELCController implements Initializable{
	@FXML private TableView<Project> projectTableView;
	@FXML private TableColumn<Project, Integer> IDColumn;
	@FXML private TableColumn<Project, String> nameColumn;
	@FXML private TableColumn<Project, Integer> LCS1Column;
	
	@FXML private TableView<LifeCycleStep> LCSTableView;
	@FXML private TableColumn<LifeCycleStep, Integer> LCSIDColumn;
	@FXML private TableColumn<LifeCycleStep, String> LCSNameColumn;
	@FXML private TableColumn<LifeCycleStep, Integer> LCSECColumn;
	@FXML private TableColumn<LifeCycleStep, Integer> LCSDColumn;
	
//	@FXML private TableColumn<Project, Integer> LCS2Column;
//	@FXML private TableColumn<Project, Integer> LCS3Column;
//	@FXML private TableColumn<Project, Integer> LCS4Column;
//	@FXML private TableColumn<Project, Integer> LCS5Column;
//	@FXML private TableColumn<Project, Integer> LCS6Column;
//	@FXML private TableColumn<Project, Integer> LCS7Column;
//	@FXML private TableColumn<Project, Integer> LCS8Column;
//	@FXML private TableColumn<Project, Integer> LCS9Column;
//	@FXML private TableColumn<Project, Integer> LCS10Column;
//	@FXML private TableColumn<Project, Integer> LCS11Column;
//	@FXML private TableColumn<Project, Integer> LCS12Column;
//	@FXML private TableColumn<Project, Integer> LCS13Column;
//	@FXML private TableColumn<Project, Integer> LCS14Column;
//	@FXML private TableColumn<Project, Integer> LCS15Column;
//	@FXML private TableColumn<Project, Integer> LCS16Column;
//	@FXML private TableColumn<Project, Integer> LCS17Column;
//	@FXML private TableColumn<Project, Integer> LCS18Column;
//	@FXML private TableColumn<Project, Integer> LCS19Column;
//	@FXML private TableColumn<Project, Integer> LCS20Column;
//	@FXML private TableColumn<Project, Integer> LCS21Column;
//	@FXML private TableColumn<Project, Integer> LCS22Column;
//	@FXML private TableColumn<Project, Integer> LCS23Column;
//	@FXML private TableColumn<Project, Integer> LCS24Column;
//	@FXML private TableColumn<Project, Integer> LCS25Column;
	
	ObservableList<Project> listM;
	
	ObservableList<LifeCycleStep> listLCS;
	
    ObservableList<Project> dataList;
	
    int index = -1;
    
	Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void updateProjectTable(){        
        
    	// Set up the columns in the table
     	IDColumn.setCellValueFactory(new PropertyValueFactory<Project, Integer>("ID"));
     	nameColumn.setCellValueFactory(new PropertyValueFactory<Project, String>("name"));
     	LCS1Column.setCellValueFactory(new PropertyValueFactory<Project, Integer>("LCS1"));
     		        
     	//load data from MySQL
        listM = mysqlconnect.getProjects();
        projectTableView.setItems(listM);
    }
    
    //Setup UI for this
    public void addProject(){    
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into project_table (ID,name,LCS1)values(?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
//            pst.setString(1, txt_username.getText());
//            pst.setString(2, txt_password.getText());
//            pst.setString(3, txt_email.getText());
//            pst.setString(4, txt_type.getText());
            pst.execute();
                        
            updateProjectTable();            
        } catch (Exception e) {            
        }
    }
    
    //Setup UI for this
    public void deleteProject(){
        conn = mysqlconnect.ConnectDb();
        String sql = "delete from project_table where user_id = ?";
            try {
                pst = conn.prepareStatement(sql);
//                pst.setString(1, txt_id.getText());
                pst.execute();                
                updateProjectTable();                
            } catch (Exception e) {            
            }
        
    }
    
    //Setup UI for this
    public void editProjectTable(){   
        try {
            conn = mysqlconnect.ConnectDb();
//            String value1 = txt_id.getText();
//            String value2 = txt_username.getText();
//            String value3 = txt_password.getText();
//            String value4 = txt_email.getText();            
//            String sql = "update users set user_id= '"+value1+"',username= '"+value2+"',password= '"+
//                    value3+"',email= '"+value4+"',type= '"+value5+"' where user_id='"+value1+"' ";
//            pst= conn.prepareStatement(sql);
            pst.execute();            
            updateProjectTable();            
        } catch (Exception e) {            
        }        
    }
    
    //Setup UI for this
    //////// select project ///////
    @FXML
    void getSelected (MouseEvent event){
    index = projectTableView.getSelectionModel().getSelectedIndex();
    if (index <= -1){

    return;
    }
//    txt_id.setText(col_id.getCellData(index).toString());
//    txt_username.setText(col_username.getCellData(index).toString());
//    txt_password.setText(col_password.getCellData(index).toString());
//    txt_email.setText(col_email.getCellData(index).toString());
//    txt_type.setText(col_type.getCellData(index).toString());

    }
    
    
    public void updateLCSTable(){        
        
    	// Set up the columns in the table
    	LCSIDColumn.setCellValueFactory(new PropertyValueFactory<LifeCycleStep, Integer>("ID"));
     	LCSNameColumn.setCellValueFactory(new PropertyValueFactory<LifeCycleStep, String>("name"));
     	LCSECColumn.setCellValueFactory(new PropertyValueFactory<LifeCycleStep, Integer>("EC"));
     	LCSDColumn.setCellValueFactory(new PropertyValueFactory<LifeCycleStep, Integer>("D"));
     		        
     	//load data from MySQL
        listLCS = mysqlconnect.getLCSs();
        LCSTableView.setItems(listLCS);
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateProjectTable();
		updateLCSTable();
	}
	
//	dummy list
//	public ObservableList<Project> getProjects(){
//		ObservableList<Project> projects = FXCollections.observableArrayList();
//		projects.add(new Project(1,"EffortLoggerV3"));
//		projects.add(new Project(2,"EffortLoggerV4"));
//		projects.add(new Project(3,"EffortLoggerV5"));
//		projects.add(new Project(4,"EffortLoggerV6"));
//		
//		return projects;
//		
//	}
	
}
