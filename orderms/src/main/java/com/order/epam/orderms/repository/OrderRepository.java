package com.order.epam.orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.epam.orderms.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	Order findByCustomerName(String customername);

}
