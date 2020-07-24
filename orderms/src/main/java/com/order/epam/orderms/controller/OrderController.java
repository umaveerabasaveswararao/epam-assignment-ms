package com.order.epam.orderms.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.order.epam.orderms.model.Order;
import com.order.epam.orderms.service.OrderService;


@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/api/v1/order/{customername}")
	//@HystrixCommand(fallbackMethod = "callOrder_Fallback")
	public Order getOrderItems(@PathVariable String customername){
		Order order = orderService.getOrderItems(customername);	
		return order;
	}

	@PostMapping("/api/v1/order/{customername}")
	public ResponseEntity<Void> createOrder(
			@PathVariable String customername, @Valid @RequestBody Order order){
		Order createdoderItem = orderService.createOrder(customername, order);	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdoderItem.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@SuppressWarnings("unused")
    private Order callOrder_Fallback(String customername) {
 
        System.out.println("Order Service is down!!! fallback route enabled...");
 
        return null;
    }
}
