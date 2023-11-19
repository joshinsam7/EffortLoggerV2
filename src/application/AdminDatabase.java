package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
	
	@SuppressWarnings("resource")
	public Boolean checkUsernameExist(String userName, File userD) {
		
		try {
			Scanner adminReader;
			adminReader = new Scanner (userD);
			
			while (adminReader.hasNextLine()) {
				String data = adminReader.nextLine(); 
				String[] infos  = data.split(":");
				
				String id = infos[0];
				
				if (id.equals(userName)) {
					return true; 
				}
			}
			
			adminReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;  
	}
	
	
	public Boolean addUserAccount(String userName, String password, File userD) {
		
		Boolean check = checkUsernameExist(userName, userD); 
		if (check == false) {
			try {
				FileOutputStream  outputStream = new FileOutputStream(userD, true); 
				
				BufferedWriter adminWriter = new BufferedWriter(new OutputStreamWriter(outputStream)); 
				
				String text = userName + ":" + password + "\n";
				
				try {
					adminWriter.write(text);
					adminWriter.close();
					
					return true; 
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
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


	public Boolean removeAccount(String username, File userD) {
	
		Boolean check = checkUsernameExist(username, userD); 
		if (check) {
			try {
	            BufferedReader fileReader = new BufferedReader(new FileReader(userD));
	            StringBuilder fileContent = new StringBuilder();
	            String line;
	
	            while ((line = fileReader.readLine()) != null) {
	                String[] infos = line.split(":");
	                String id = infos[0];
	
	                
	                if (!id.equals(username)) {
	                    fileContent.append(line).append("\n");
	                }
	            }
	
	            fileReader.close();
	
	            // Write the modified content back to the file
	            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(userD));
	            fileWriter.write(fileContent.toString());
	            fileWriter.close();
	
	            // Account removed successfully
	            return true;
	
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
        return false;
    }
}
