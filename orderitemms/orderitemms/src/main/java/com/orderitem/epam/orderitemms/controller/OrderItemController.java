package com.orderitem.epam.orderitemms.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.orderitem.epam.orderitemms.model.OrderItem;
import com.orderitem.epam.orderitemms.service.OrderItemService;

@RestController
public class OrderItemController {
	@Autowired
	OrderItemService orderItemService;
	
	
	@GetMapping("/api/v1/orderitems/{orderid}")
	@HystrixCommand(fallbackMethod = "callOrderItem_Fallback")
	public List<OrderItem> getOrderItems(@PathVariable Integer orderid){
		return orderItemService.getOrderItems(orderid);
	}

	@PostMapping("/api/v1/orderitems/{orderid}")
	public ResponseEntity<Void> createOrderItems(
			@PathVariable Integer orderid, @Valid @RequestBody List<OrderItem> orderItems){
		
		OrderItem createdoderItem	= orderItemService.createOrderItems(orderid, orderItems);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{productcode}").buildAndExpand(createdoderItem.getProductCode()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@SuppressWarnings("unused")
    private List<OrderItem> callOrderItem_Fallback(Integer orderId) {
 
        System.out.println("Order Item Service is down!!! fallback route enabled...");
        List<OrderItem> list = new ArrayList<OrderItem>();
        OrderItem item = new OrderItem();
        item.setOrderId(orderId);
        item.setProductName("dummy");
        item.setQuantity(0);
        item.setProductCode(0);
        list.add(item);
 
        return list;
    }
}
