package application;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.Parent;
import java.net.URL;

import application.Entity.Project;

import java.io.File;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class UserWindow extends Stage {
	public UserWindow(){
		
		 try {
			setTitle("Effort Logger V2");
		 	
			URL url = new File("src/application/fxmlUI/MainConsole.fxml").toURI().toURL();
			
		 	Parent root = FXMLLoader.load(url);			
		 	Scene scene = new Scene(root,740,560);
		 	 	
		 	setScene(scene);		 	
		 } catch(Exception e) {
		 	e.printStackTrace();
		 } 
	}
}
