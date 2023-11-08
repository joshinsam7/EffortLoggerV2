package application;

import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class AdminWindow extends Stage {
	
	private AdminDatabase adminDatabase;
	
	public AdminWindow() {
		setTitle("Admin"); 
		
		HBox adminLayout = new HBox(10); 
		
		Label create_new = new Label("Create new Account");
		create_new.setAlignment(Pos.TOP_LEFT); 
		
//		create_new.setOnAction(event -> {
//			adminDatabase.addUserAccount(, getFullScreenExitHint(), null)
//		});
		
		Label remove = new Label();
		remove.setText("Remove");

		
		adminLayout.setAlignment(Pos.TOP_LEFT);
		
		
		adminLayout.getChildren().add(create_new); 
		adminLayout.getChildren().add(remove); 
		
		Scene adminScene = new Scene (adminLayout, 600, 400); 
		setScene(adminScene); 
	}
}
