package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.stage.Stage;

public class Main extends Application {
	
	private AdminDatabase adminDatabase;
	private UserDatabase userDatabase; 

	public Main() {
    	adminDatabase = new AdminDatabase();
        userDatabase = new UserDatabase(); 
    }

	@Override
	public void start(Stage primaryStage) {
		
		//Connect to the database
		DBConnect();
		
		try {
            primaryStage.setTitle("Login");

            TextField usernameField = new TextField();
            usernameField.setPromptText("Username");

            usernameField.setText("joshinsam");
            
            PasswordField passwordField = new PasswordField();
            passwordField.setPromptText("Password");
            
            passwordField.setText("playstation5"); 
            
            Button login = new Button("LOGIN");

            CheckBox admin_cb = new CheckBox("admin") ; 
            admin_cb.setIndeterminate(false);
            
            admin_cb.setSelected(true); 
            
            InputStream UIstream = new FileInputStream("src/application/user.png");
            Image userImage = new Image(UIstream);
            
            InputStream PIstream = new FileInputStream("src/application/padlock.png");
            Image passwordImage = new Image(PIstream);

            
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
            
            Scene scene = new Scene(root, 600, 400);
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

	public static void main(String[] args) {		
		launch(args);
	}

	public void DBConnect() {
		try {
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/effortloggerdb",username,password);
			System.out.print("Connected to the database!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
