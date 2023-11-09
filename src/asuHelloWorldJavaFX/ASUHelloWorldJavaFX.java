package asuHelloWorldJavaFX;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class ASUHelloWorldJavaFX extends Application {
	
	private AdminDatabase adminDatabase;
	private UserDatabase userDatabase; 

    public static void main(String[] args) {
        launch(args);
    }
    
    public ASUHelloWorldJavaFX() {
    	adminDatabase = new AdminDatabase();
        userDatabase = new UserDatabase(); 
    }
    

    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Login");

            TextField usernameField = new TextField();
            usernameField.setPromptText("Username");

            
            PasswordField passwordField = new PasswordField();
            passwordField.setPromptText("Password");
            
            
            Button login = new Button("LOGIN");

            CheckBox admin_cb = new CheckBox("admin") ; 
            admin_cb.setIndeterminate(false);
            
            Image userImage = new Image("/asuHelloWorldJavaFX/user.png");
            Image passwordImage = new Image("/asuHelloWorldJavaFX/padlock.png");

            
            ImageView userImageView = new ImageView(userImage);
            userImageView.setFitWidth(15); 
            userImageView.setFitHeight(15); 

            ImageView passwordImageView = new ImageView(passwordImage);
            passwordImageView.setFitWidth(15); 
            passwordImageView.setFitHeight(15);

            GridPane root = new GridPane();
            root.setHgap(10); 
            root.setVgap(10); 
            root.setPadding(new Insets(10)); 

            
            root.add(userImageView, 0, 0); 
            root.add(usernameField, 1, 0); 
            root.add(passwordImageView, 0, 1); 
            root.add(passwordField, 1, 1); 
            
            VBox in_root = new VBox(10); 
            
            in_root.getChildren().add(admin_cb); 
            in_root.getChildren().add(login); 
            
            in_root.setAlignment(Pos.CENTER); 
            root.add(in_root,1,2); 
            
            root.setAlignment(Pos.CENTER); 
            
            
            login.setOnAction(event -> {
            
            	//Perform authentication
            	String userName = usernameField.getText();
            	String password = passwordField.getText(); 
            	
            	File adminD = new File("AdminDatabase.txt");
            	File userD = new File("UserDatabase.txt");
            	
            	if (admin_cb.isSelected()) {
            		
            		Boolean check = adminDatabase.checkAdminAuthentication(userName, password,adminD);
				 		if (check) {            		
				 				openAdminWindow(userD, adminD,adminDatabase); 
						}
						else {
							showAlert("The password or username you entered is incorrect");
						}
            	}
            	else {
					Boolean check = userDatabase.checkUserAuthentication(userName, password, userD);
						if (check) {            		
							openUserWindow(); 
						}
						else {
							showAlert("The password or username you entered is incorrect");
						}
            	}
            }); 
            
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void showAlert(String message) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("");
    	alert.setContentText(message);
        alert.showAndWait();
    }

	private void openAdminWindow(File userD, File adminD,AdminDatabase adminDatabase) {
    	AdminWindow adminWindow = new AdminWindow(adminDatabase, userD, adminD); 
    	adminWindow.show() ;
    }
    
    private void openUserWindow() {
    	UserWindow userWindow = new UserWindow(); 
    	userWindow.show(); 
    }
}