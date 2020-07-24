package com.orderitem.epam.orderitemms.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.order.epam.orderms.controller.OrderController;

@WebMvcTest(OrderController.class)
public class OrderItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void OrderItem_Test() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/v1/umaveera/order")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
	    System.out.println(result.getResponse().getContentAsString());
	}

}
