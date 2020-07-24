package com.order.epam.orderms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.epam.orderms.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	List<Address> findByOrderId(int id);

}
