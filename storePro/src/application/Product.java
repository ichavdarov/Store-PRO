package application;

import java.math.BigDecimal;

public class Product {
private String name;
private String description;
private BigDecimal clientPrice;
private String category;
private int quantity;
private String barcode;
private int StorageId;

public Product(String name, String description, BigDecimal clientPrice, int quantity,String category,String barcode,int StorageId) {
	this.name = name;
	this.category=category;
	this.description = description;
	this.clientPrice = clientPrice;
	this.quantity = quantity;
	this.barcode=barcode;
	this.StorageId=StorageId;
}
public int getStorageId() {
	return StorageId;
}
public void setStorageId(int storageId) {
	StorageId = storageId;
}
public Product() {
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
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


public String getBarcode() {
	return barcode;
}

public void setBarcode(String barcode) {
	this.barcode = barcode;
}
}
