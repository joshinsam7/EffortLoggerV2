package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
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

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Login");

            TextField usernameField = new TextField();
            usernameField.setPromptText("Username");

            PasswordField passwordField = new PasswordField();
            passwordField.setPromptText("Password");

            CheckBox cb = new CheckBox("Remember me");
            cb.setIndeterminate(false);

            Button login = new Button("LOGIN");

      
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
            in_root.getChildren().add(cb); 
            in_root.getChildren().add(login); 
            in_root.setAlignment(Pos.CENTER); 
            root.add(in_root,1,2); 
            
            root.setAlignment(Pos.CENTER); 
            
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
