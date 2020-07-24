package com.order.epam.orderms.model;

public class OrderItem {
	
	public int productCode;
	public String productName;
	public int quantity;
	
	public OrderItem() {
	}
	
	public OrderItem(int productCode, String productName, int quantity) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
	}

	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [productCode=" + productCode + ", productName=" + productName + ", quantity=" + quantity
				+ "]";
	}

	
}
