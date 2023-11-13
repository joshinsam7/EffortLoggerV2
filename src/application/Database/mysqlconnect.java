package application.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

import application.Entity.Project;
import application.Entity.Defect;
import application.Entity.Effort;
import application.Entity.EffortCategory;
import application.Entity.LifeCycleStep;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class mysqlconnect {
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	
	public static ObservableList<Effort> listE = FXCollections.observableArrayList();
	public static ObservableList<String> effortChoices = FXCollections.observableArrayList();
	
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
        
        try {
            listE.clear();
        	PreparedStatement ps = conn.prepareStatement("select * from effort_table");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){                
                listE.add(new Effort(
                        Integer.parseInt(rs.getString("ID")),
                        new Date(dateFormat.parse(rs.getString("Date")).getTime()),
                        new Time(timeFormat.parse(rs.getString("Start")).getTime()),
                        new Time(timeFormat.parse(rs.getString("Stop")).getTime()),
                        Double.parseDouble(rs.getString("Time")),
                        Integer.parseInt(rs.getString("LCS")),
                        Integer.parseInt(rs.getString("EC")),
                        Integer.parseInt(rs.getString("DI"))
                ));                
           }
        } catch (Exception e) {
        }
        return listE;
	}    
	
	public static Effort getOneEffort(String ID) {
		Connection conn = ConnectDb();
        
        try {
            
        	PreparedStatement ps = conn.prepareStatement("select * from effort_table where id = ?");
        	ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
            Effort res = new Effort(
                        Integer.parseInt(rs.getString("ID")),
                        new Date(dateFormat.parse(rs.getString("Date")).getTime()),
                        new Time(timeFormat.parse(rs.getString("Start")).getTime()),
                        new Time(timeFormat.parse(rs.getString("Stop")).getTime()),
                        Double.parseDouble(rs.getString("Time")),
                        Integer.parseInt(rs.getString("LCS")),
                        Integer.parseInt(rs.getString("EC")),
                        Integer.parseInt(rs.getString("DI"))
           );                
            return res;
           }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
	} 
	
	public static ObservableList<Defect> getDefects() {
		Connection conn = ConnectDb();
        ObservableList<Defect> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from defect_table");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Defect(Integer.parseInt(rs.getString("ID")), 
                		rs.getString("Name"),
                		rs.getString("Detail"),
                		rs.getBoolean("Status")
                		));
            }
            System.out.println(rs.getBoolean("Status"));
        } catch (Exception e) {
        }
        return list;
	}	
	
	public static ObservableList<String> getEffortChoices() {                
		try {
			getEfforts();			
			effortChoices.clear();
			//Convert list of Effort to list of String
			for(Effort e : listE) {
	    		effortChoices.add(e.toString());
	    	}			
			return effortChoices;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                 
        return effortChoices;
	}
}

