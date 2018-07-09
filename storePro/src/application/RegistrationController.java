package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistrationController implements Initializable{

@FXML	private AnchorPane topPane;
@FXML 	private Button backBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		topPane.setStyle("-fx-background-color: #0000ff;");
		
	}
	@FXML protected void handleBackBtnAction(ActionEvent event) {
	   	StageSetter setter=new StageSetter();
		setter.setStage("login.fxml", backBtn,"Login");
	}

}
