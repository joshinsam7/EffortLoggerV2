package application;

import javafx.stage.Stage;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


public class AdminWindow extends Stage {
	
	private AdminDatabase dataDatabase;
	
	public AdminWindow(AdminDatabase adminDatabase, File userD, File adminD) {
    	setTitle("Admin");

        HBox adminLayout = new HBox(50);
        
        Label createLabel = new Label("Create :");
        createLabel.setAlignment(Pos.TOP_LEFT);

        Label removeLabel = new Label("Remove :");
        removeLabel.setAlignment(Pos.TOP_LEFT);

        VBox createLayout = new VBox();
        Label newUsernameLabel = new Label("New Username:");
        TextField enterNewUsername = new TextField("");
        Label newPasswordLabel = new Label("New Password:");
        PasswordField enterNewPassword = new PasswordField();

        VBox removeLayout = new VBox();
        Label usernameLabel = new Label("Username:");
        TextField enterUsername = new TextField("");

        Button createButton = new Button("Submit");
        Button removeButton = new Button("Submit");

        
        Region spacingRegion1 = new Region();
        Region spacingRegion2 = new Region();
        
        spacingRegion1.setMinHeight(10);
        spacingRegion2.setMinHeight(10);
        
        Label statusLabelCreating = new Label();
        Label statusLabelRemoving = new Label(); 
        
        createButton.setOnAction(event -> {
            String newUsername = enterNewUsername.getText();
            String newPassword = enterNewPassword.getText();
            dataDatabase = new AdminDatabase();
            Boolean checkForAdding = dataDatabase.addUserAccount(newUsername, newPassword, userD); 
            if (checkForAdding == true) {
            	statusLabelCreating.setText("Created Successfully!");
            }
            else {
            	statusLabelCreating.setText("Username already exists");
            }
        });

        removeButton.setOnAction(event -> {
            // Implement the code to remove a user account here
        	String usernameTOremove = enterUsername.getText();
        	dataDatabase = new AdminDatabase();
        	Boolean checkForremoving = dataDatabase.removeAccount(usernameTOremove, userD); 
        	if (checkForremoving == false) {
        		statusLabelRemoving.setText("Username does not exist!");
        	}
        	else {
        		statusLabelRemoving.setText("Removed Successfully");
        	}
        
        	
        });

        adminLayout.setAlignment(Pos.TOP_LEFT);

        createLayout.getChildren().addAll(newUsernameLabel, enterNewUsername, newPasswordLabel, enterNewPassword,spacingRegion1, createButton, statusLabelCreating);
        removeLayout.getChildren().addAll(usernameLabel, enterUsername, spacingRegion2, removeButton, statusLabelRemoving);

        adminLayout.getChildren().addAll(createLabel, createLayout, removeLabel, removeLayout);

        Scene adminScene = new Scene(adminLayout, 600, 400);
        setScene(adminScene);
    }
}
