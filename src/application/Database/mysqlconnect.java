package application.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.Entity.Project;
import application.Entity.EffortCategory;
import application.Entity.LifeCycleStep;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class mysqlconnect {
	
	Connection conn = null;
    public static Connection ConnectDb(){
        try {            
            String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/effortloggerdb",username,password);			
            return conn;
        } catch (Exception e) {            
            return null;
        }
    }
    
    public static ObservableList<Project> getProjects(){
        Connection conn = ConnectDb();
        ObservableList<Project> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from project_table");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Project(Integer.parseInt(rs.getString("ID")), 
                		rs.getString("Name"), 
                		Integer.parseInt(rs.getString("LCS1"))));
            }
        } catch (Exception e) {
        }
        return list;
    }    
    
    public static ObservableList<LifeCycleStep> getLCSs(){
        Connection conn = ConnectDb();
        ObservableList<LifeCycleStep> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from LCS_table");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new LifeCycleStep(Integer.parseInt(rs.getString("ID")), 
                		rs.getString("Name"), 
                		Integer.parseInt(rs.getString("EC")),
                		Integer.parseInt(rs.getString("D"))
                		));
            }
        } catch (Exception e) {
        }
        return list;
    }

	public static ObservableList<EffortCategory> getECs() {
		Connection conn = ConnectDb();
        ObservableList<EffortCategory> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from ec_table");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new EffortCategory(Integer.parseInt(rs.getString("ID")), 
                		rs.getString("Name")
                		));
            }
        } catch (Exception e) {
        }
        return list;
	}    
}

