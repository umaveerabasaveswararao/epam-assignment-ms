package com.order.epam.orderms.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.epam.orderms.model.OrderItem;


@FeignClient(name="orderitemms")
public interface OrderItemFeignClientProxy {
	
	@GetMapping("/api/v1/orderitems/{orderid}")
	public List<OrderItem> retrieveOrderItems(@PathVariable(value="orderid") int orderid);
	
	@PostMapping("/api/v1/orderitems/{orderid}")
	public void createOrderItems(@PathVariable(value="orderid") int orderid,
			@RequestBody List<OrderItem> orderItems);

}
