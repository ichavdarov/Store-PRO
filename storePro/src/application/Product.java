package application;

import java.math.BigDecimal;

public class Product {
private String name;
private String description;
private BigDecimal clientPrice;
private int quantity;
public Product(String name, String description, BigDecimal clientPrice, int quantity) {
	this.name = name;
	this.description = description;
	this.clientPrice = clientPrice;
	this.quantity = quantity;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public BigDecimal getClientPrice() {
	return clientPrice;
}
public void setClientPrice(BigDecimal clientPrice) {
	this.clientPrice = clientPrice;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
