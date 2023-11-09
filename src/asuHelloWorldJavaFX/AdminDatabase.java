package asuHelloWorldJavaFX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Boolean addUserAccount(String userName, String password, File userD) {
	    try {
	        FileReader fileReader = new FileReader(userD);
	        
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        
	        StringBuilder fileContent = new StringBuilder();
	        String line;

	       
	        boolean nullLineFound = false;
	        
	        while ((line = bufferedReader.readLine()) != null) {
	            if (line.trim().isEmpty()) {
	                fileContent.append(userName).append(":").append(password).append("\n");
	                nullLineFound = true;
	            } else {
	                fileContent.append(line).append("\n");
	            }
	        }
	       
	        if (!nullLineFound) {
	            fileContent.append(userName).append(":").append(password).append("\n");
	        }
	        
	        bufferedReader.close();

	        
	        FileWriter fileWriter = new FileWriter(userD);
	        
	        BufferedWriter adminWriter = new BufferedWriter(fileWriter);
	        
	        adminWriter.write(fileContent.toString());
	        adminWriter.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }

	    return true;
	}
}
