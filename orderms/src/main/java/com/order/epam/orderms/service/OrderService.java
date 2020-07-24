package com.order.epam.orderms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.epam.orderms.config.OrderItemFeignClientProxy;
import com.order.epam.orderms.exception.OrderNotFoundException;
import com.order.epam.orderms.model.Address;
import com.order.epam.orderms.model.Order;
import com.order.epam.orderms.model.OrderItem;
import com.order.epam.orderms.repository.AddressRepository;
import com.order.epam.orderms.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRespository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	OrderItemFeignClientProxy proxy;
	
	public Order getOrderItems(String customername){
		Order order = orderRespository.findByCustomerName(customername);
		if( order == null ) {
			throw new OrderNotFoundException("Order Not Found For Customer with Name : " + customername);
		}
		List<OrderItem> list = proxy.retrieveOrderItems(order.getId());
		if(list.isEmpty()) {
			throw new OrderNotFoundException("Order Not Found For Customer with Name : " + customername);
		}
		List<Address> addresses = addressRepository.findByOrderId(order.getId());
		order.setOrderItems(list);
		order.setAddress(addresses);
		return order;
	}
	
	public Order createOrder(
			 String customername, Order order){
		List<OrderItem> orderItems = order.getOrderItems();
		Order checkOrderExists = orderRespository.findByCustomerName(customername);
		String checkUser = "";
		if( checkOrderExists != null ) {
			 checkUser = checkOrderExists.getCustomerName();
		}
		
		Order createdoderItem = null;
		if( checkUser != customername ) {
			 createdoderItem = orderRespository.save(order);
			 for(Address add: order.getAddress()) {
				 add.setOrderId(order.getId());
				 addressRepository.save(add);
			 }
			 proxy.createOrderItems(order.getId(), orderItems);
			 
		}
		
		return createdoderItem;
	}

}
