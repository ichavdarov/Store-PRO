package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SaleController implements Initializable{
	@FXML private TextField txtBarcode;
	@FXML private TextField txtQuantity;
	@FXML private TableView tblViewSale;
	@FXML private Label lblTtlPrice;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	@FXML protected void handleBtnAddAction() {
	
	}
	
	@FXML protected void handleBtnSellAction() {
		
	}

}
