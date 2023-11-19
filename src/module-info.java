module EffortLoggerV2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	requires org.junit.jupiter.api;
	
	exports application.Controller;
	opens application.Controller to javafx.fxml;
	
	exports application.Entity;
	opens application.Entity to javafx.base;
	
	
	opens application to javafx.graphics, javafx.fxml;
	 
	
}
