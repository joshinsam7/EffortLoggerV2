package asuHelloWorldJavaFX;

import javafx.stage.Stage;
import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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
        TextField enterNewPassword = new TextField("");

        VBox removeLayout = new VBox();
        Label usernameLabel = new Label("Username:");
        TextField enterUsername = new TextField("");
        Label passwordLabel = new Label("Password:");
        TextField enterPassword = new TextField("");

        Button createButton = new Button("Submit");
        Button removeButton = new Button("Submit");

        createButton.setOnAction(event -> {
            String newUsername = enterNewUsername.getText();
            String newPassword = enterNewPassword.getText();
            dataDatabase = new AdminDatabase();
            dataDatabase.addUserAccount(newUsername, newPassword, userD); 
            
        });

        removeButton.setOnAction(event -> {
            // Implement the code to remove a user account here
        	
        });

        adminLayout.setAlignment(Pos.TOP_LEFT);

        createLayout.getChildren().addAll(newUsernameLabel, enterNewUsername, newPasswordLabel, enterNewPassword, createButton);
        removeLayout.getChildren().addAll(usernameLabel, enterUsername, passwordLabel, enterPassword, removeButton);

        adminLayout.getChildren().addAll(createLabel, createLayout, removeLabel, removeLayout);

        Scene adminScene = new Scene(adminLayout, 600, 400);
        setScene(adminScene);
    }
}
        
