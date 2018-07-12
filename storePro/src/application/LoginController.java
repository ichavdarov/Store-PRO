package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
public class LoginController implements Initializable{
	@FXML private Button btnLogIn;
	@FXML private Hyperlink hplRegister;
	@FXML private Hyperlink hplShopRegister;
	@FXML private TextField txtUsername;
	@FXML private PasswordField passField;
	@FXML private AnchorPane topPane;
	@Override
	public void initialize(URL url, ResourceBundle rb) { 
		topPane.setStyle("-fx-background-color: #0000ff;");
	
	
	}
	
	@FXML protected void handleRegisterHplAction(ActionEvent event) {

		StageSetter setter=new StageSetter();
		setter.setStage("register.fxml", hplRegister,"Register form");
	}
	@FXML protected void handleRegisterShopHplAction(ActionEvent event) {

		StageSetter setter=new StageSetter();
		setter.setStage("registerShop.fxml", hplShopRegister,"New shop registration form");
	}
	@FXML protected void handleBtnLogInAction(ActionEvent event) {
		MySqlConnector connector=new MySqlConnector();
		AllertMessage allert=new AllertMessage();
	
		if((connector.LogIn(/*txtUsername.getText()*/"dancho",/* passField.getText()*/"baidancho"))) {
			allert.showAlert(Alert.AlertType.INFORMATION, btnLogIn.getScene().getWindow(), "log in successfull", "log in successfull");
			StageSetter setter=new StageSetter();
			setter.setStage("MainScreen.fxml", btnLogIn,"Main screen");
		}
		else
			allert.showAlert(Alert.AlertType.ERROR, btnLogIn.getScene().getWindow(),"Wrong username or password!", "Wrong username or password!");
	}

}



