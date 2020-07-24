package com.orderitem.epam.orderitemms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue
	public int productCode;
	public String productName;
	public int quantity;
	public int orderId;
	
	public OrderItem() {
	}
	
	public OrderItem(int productCode, String productName, int quantity, int orderId) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
		this.orderId = orderId;
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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderItem [productCode=" + productCode + ", productName=" + productName + ", quantity=" + quantity
				+ ", orderId=" + orderId + "]";
	}
	
}
