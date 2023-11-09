package asuHelloWorldJavaFX;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UserWindow extends Stage {
    public UserWindow() {

    	double menuButtonWidth = 300; 
        double menuButtonHeight = 30;
    	
        VBox pros = new VBox(80);

        HBox buttonBox = new HBox(10);
        VBox menuBox = new VBox(10);

        setTitle("EffortLogger Console");

        Button start = new Button("Start Activity");
        Button stop = new Button("Stop Activity");

        MenuButton mb_project = new MenuButton("Project:");
        mb_project.getItems().addAll(new MenuItem("Project 1"), new MenuItem("Project 2"));
        mb_project.setPrefSize(menuButtonWidth, menuButtonHeight);
        
        MenuButton mb_lcs = new MenuButton("Life Cycle Step:");
        mb_lcs.getItems().addAll(new MenuItem("Step 1"), new MenuItem("Step 2"));
        mb_lcs.setPrefSize(menuButtonWidth, menuButtonHeight);
        
        MenuButton mb_ec = new MenuButton("Effort Category:");
        mb_ec.getItems().addAll(new MenuItem("Effort Category 1"), new MenuItem("Effort Category 2"));
        mb_ec.setPrefSize(menuButtonWidth, menuButtonHeight);
        
        buttonBox.getChildren().addAll(start, stop);
        buttonBox.setAlignment(Pos.CENTER);

        menuBox.getChildren().addAll(mb_project, mb_lcs, mb_ec);
        menuBox.setPadding(new Insets(100, 0, 0, 0));
        
        menuBox.setAlignment(Pos.CENTER);

        pros.getChildren().addAll(menuBox, buttonBox);

        Scene userScene = new Scene(pros, 600, 400);
        setScene(userScene);
    }
}