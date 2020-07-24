package com.orderitem.epam.orderitemms.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderitem.epam.orderitemms.model.OrderItem;

@Repository
public interface OrderItemRespository extends JpaRepository<OrderItem, Integer> {

	List<OrderItem> findByOrderId(int orderid);

}
