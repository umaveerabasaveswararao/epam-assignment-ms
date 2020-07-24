package com.orderitem.epam.orderitemms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderitem.epam.orderitemms.model.OrderItem;
import com.orderitem.epam.orderitemms.respository.OrderItemRespository;

@Service
public class OrderItemService {
	
	@Autowired
	OrderItemRespository orderItemRespository;
	
	public List<OrderItem> getOrderItems(Integer orderid){
		return orderItemRespository.findByOrderId(orderid);
	}

	public OrderItem createOrderItems(Integer orderid, List<OrderItem> orderItems) {
		orderItems.stream().forEach(e -> e.setOrderId(orderid));
		OrderItem createdoderItem = null;
		for(OrderItem orderItem: orderItems) {
			 createdoderItem = orderItemRespository.save(orderItem);
		}
		
		return createdoderItem;
	}
}
