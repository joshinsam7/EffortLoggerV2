package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserDatabase {
	
	public UserDatabase() {
		
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
				
				if (id.equals(userName) && pass.equals(password)) {
					return true; 
				}
			}
			userReader.close(); 
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
			
		}
		
		return false;
	}
	
}

//joshinsam:jnsdjcn