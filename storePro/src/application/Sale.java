package application;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale {
private	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

private List<Product> productsList;
private String SaleDate;
private BigDecimal total;
public Sale() {
	this.productsList = new ArrayList<Product>();
	Date CurrentDate = new Date();
	this.SaleDate = dateFormat.format(CurrentDate);	
}
public List<Product> getProductsList() {
	return productsList;
}
public void addProductsToList(Product product) {
	this.productsList.add(product);
	calculateTotal(product.getClientPrice());
}
public String getSaleDate() {
	return SaleDate;
}
public BigDecimal getTotal() {
	return total;
}
public void calculateTotal(BigDecimal productPrice) {
	
	this.total.add(productPrice);
}
}
