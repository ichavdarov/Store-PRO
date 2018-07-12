package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class StageSetter {
	public StageSetter() {
		
	}
	public void setStage(String fxmlResourse, Control stageSourse, String stageName) {
		 Stage stage = null;
	       Parent myNewScene = null;
	       stage = (Stage) stageSourse.getScene().getWindow();
	       try {
	    	 
			myNewScene = FXMLLoader.load(getClass().getResource(fxmlResourse));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       Scene scene = new Scene(myNewScene);
	       scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	       stage.setScene(scene);
	       stage.setTitle("stageName");
	       stage.centerOnScreen();
	       stage.show();
	       

	}

}
