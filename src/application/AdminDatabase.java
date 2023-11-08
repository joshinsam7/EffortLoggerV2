package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

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
	
}
