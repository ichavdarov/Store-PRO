package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainScreenController implements Initializable {
	
	@FXML private AnchorPane topPane;
	@FXML TextField txtName;
	@FXML private AnchorPane mainPain;
	@FXML private TableView<Product> tblProducts;
	@FXML TextField txtCategory;
	@FXML TextField txtBarcode;
	@FXML TextField txtPrice;
	@FXML TextField txtSearch;
	@FXML TextArea  txtArDescription;
	@FXML Button  btnSale;
	private ObservableList<Product> masterData;
private MySqlConnector connector=null;

	public MySqlConnector getConnector() {
	return connector;
}

public void setConnector(MySqlConnector connector) {
	this.connector = connector;
}

	public void initialize(URL url, ResourceBundle rb) { 
		topPane.setStyle("-fx-background-color: #0000ff;");
	MySqlConnector connector =new MySqlConnector();
	masterData = FXCollections.observableArrayList();
	masterData=connector.getProductsInThisStrore();
	initFilter();
	initTable();
	
			}
@FXML protected void handleBtnSaleAction(ActionEvent event) {
	AnchorPane root;
	try {
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("sale.fxml"));
		Scene secondScene = new Scene(root);
		Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);
        newWindow.show();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 
	}
@FXML protected void handleBtnEditAction(ActionEvent event) {

//to do
		
	}
	private void initFilter() {
       
		txtSearch.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable o) {
               if(txtSearch.textProperty().get().isEmpty()) {
                	tblProducts.setItems(masterData);
                    return;
                }
                ObservableList<Product> tableItems = FXCollections.observableArrayList();
                ObservableList<TableColumn<Product, ?>> cols = tblProducts.getColumns();
                for(int i=0; i<masterData.size(); i++) {
                    
                    for(int j=0; j<cols.size(); j++) {
                        TableColumn col = cols.get(j);
                        String cellValue = col.getCellData(masterData.get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if(cellValue.contains(txtSearch.textProperty().get().toLowerCase())) {
                            tableItems.add(masterData.get(i));
                            break;
                        }                        
                    }

                }
                tblProducts.setItems(tableItems);
            }

        });
    }
	public void initTable() {
		tblProducts.setItems(masterData);
		 TableColumn<Product,String> nameCol = new TableColumn<Product,String>("Name");
		 nameCol.setCellValueFactory(new PropertyValueFactory("name"));
		 TableColumn<Product,String> categoryCol = new TableColumn<Product,String>("Category");
		 categoryCol.setCellValueFactory(new PropertyValueFactory("category"));
		 TableColumn<Product,String> barcodeCol = new TableColumn<Product,String>("Barcode");
		 barcodeCol.setCellValueFactory(new PropertyValueFactory("barcode"));
		 TableColumn<Product,String> clientPrice = new TableColumn<Product,String>("ClientPrice");
		 clientPrice.setCellValueFactory(new PropertyValueFactory("clientPrice"));
		 TableColumn<Product,String> quantityCol = new TableColumn<Product,String>("Quantity");
		 quantityCol.setCellValueFactory(new PropertyValueFactory("quantity"));
		 tblProducts.getColumns().setAll(nameCol, categoryCol,barcodeCol,clientPrice,quantityCol);
		 tblProducts.setRowFactory(p -> {
		     TableRow<Product> row = new TableRow<>();
		     row.setOnMouseClicked(event -> {
		         if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
		              && event.getClickCount() == 1) {
		        	 Product clickedRow = row.getItem();
		        	 txtName.setText(clickedRow.getName());
		        	 txtCategory.setText(clickedRow.getCategory());
		        	 txtBarcode.setText(clickedRow.getBarcode());
		        	 txtArDescription.setText(clickedRow.getDescription());
		        	 txtPrice.setText(clickedRow.getClientPrice().toString());
		        	 
		        	}
		     });
		     return row ;
		 });
	}
}