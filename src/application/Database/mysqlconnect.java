package application.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;

import application.Entity.Project;
import application.Entity.Effort;
import application.Entity.EffortCategory;
import application.Entity.LifeCycleStep;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class mysqlconnect {
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	
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
	
	public static ObservableList<Effort> getEfforts() {
		Connection conn = ConnectDb();
        ObservableList<Effort> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from effort_table");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){                
                list.add(new Effort(
                        Integer.parseInt(rs.getString("ID")),
                        new Date(dateFormat.parse(rs.getString("Date")).getTime()),
                        new Time(timeFormat.parse(rs.getString("Start")).getTime()),
                        new Time(timeFormat.parse(rs.getString("Stop")).getTime()),
                        Double.parseDouble(rs.getString("Time")),
                        Integer.parseInt(rs.getString("LCS")),
                        Integer.parseInt(rs.getString("EC")),
                        Integer.parseInt(rs.getString("DI"))
                ));

//            	System.out.println(rs.toString());
//            	System.out.println(rs.getString("ID"));
//            	System.out.println(rs.getString("Date"));
//            	System.out.println(rs.getString("Start"));
//            	System.out.println(rs.getString("Stop"));
//            	System.out.println(rs.getString("Time"));
//            	System.out.println(rs.getString("LCS"));
//            	System.out.println(rs.getString("EC"));
//            	System.out.println(rs.getString("DI"));
            }
        } catch (Exception e) {
        }
        return list;
	}    
}

