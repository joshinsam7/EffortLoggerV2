package application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class UserWindow extends Stage {
	public UserWindow(){
		
		VBox pros = new VBox(80); 
		
		HBox ss = new HBox(10);
		
		setTitle("Effort Logg Console"); 
		
		Button start = new Button();
		start.setText("Start Activity");
		
		Button stop = new Button();
		stop.setText("Stop Activity");
		
		ss.getChildren().addAll(start, stop); 
		ss.setAlignment(Pos.BASELINE_CENTER);
		
		Scene userScene = new Scene(pros,600,400); 
		setScene(userScene); 
	}
}
