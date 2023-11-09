package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class AdminDatabase {
	
	

	public Boolean checkAdminAuthentication(String userName, String password, File adminD) {
	    
		try {
			Scanner adminReader;
			adminReader = new Scanner (adminD);
			
			while (adminReader.hasNextLine()) {
				String data = adminReader.nextLine(); 
				String[] infos  = data.split(":");
				
				String id = infos[0];
				String pass = infos[1]; 
				
				if (id.equals(userName) && pass.equals(password)) {
					return true; 
				}
			}
			adminReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Boolean addUserAccount(String userName, String password, File userD) {
		
		try {
			FileOutputStream  outputStream = new FileOutputStream(userD, true); 
			
			BufferedWriter adminWriter = new BufferedWriter(new OutputStreamWriter(outputStream)); 
			
			String text = userName + " " + password + "\n";
			
			try {
				
				adminWriter.write(text);
				adminWriter.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false; 
	}
	
	
	public Boolean checkUserAuthentication(String userName, String password, File userD) {
		
		Scanner userReader;
		try {
			userReader = new Scanner (userD);
			
			while (userReader.hasNextLine()) {
				String data = userReader.nextLine(); 
				String[] infos  = data.split(":");
				
				String id = infos[0];
				String pass = infos[1]; 
				
				if (id.equals(userName) || pass.equals(password)) {
					return true; 
				}
			}
			userReader.close(); 
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		}
		return false;
}
	
	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("");
		alert.setContentText(message);
	    alert.showAndWait();
	}


	public Boolean removeAccount(String username) {
	//	Boolean check = 
		
		return false;
	}

	
}
