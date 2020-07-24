package com.order.epam.orderms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "order_table")
public class Order {
	
	@Id
	@GeneratedValue
	public int id;
	@NotNull
	@Size(min=3, max=10, message="Enter Max of 10 characters only")
	public String customerName;
	@OneToMany (cascade = CascadeType.ALL)
	public List<Address> address;
	@Transient
	public List<OrderItem> orderItems;
	public int amount;
	@Temporal(TemporalType.DATE)
	public Date orderDate;
	
	
	public Order() {
	}
	
	
	public Order(int id, String customerName,
			List<Address> address, List<OrderItem> orderItems, int amount, Date ordeDate) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.address = address;
		this.orderItems = orderItems;
		this.amount = amount;
		this.orderDate = ordeDate;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", customerName=" + customerName + ", address=" + address + ","
				+ " amount=" + amount + ", orderDate=" + orderDate + "]";
	}
    
	
	
}
