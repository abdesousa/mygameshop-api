package com.mygameshop.api.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mygameshop.api.persistence.model.Order;
import com.mygameshop.api.persistence.repository.OrderRepository;
import com.mygameshop.api.service.OrderService;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
	
	@Override
	public void save(Optional<Order> order) {
		if (order.isPresent()) {
			orderRepository.save(order.get());
		}
	}

	@Override
	public List<Order> list() {

		List<Order> orderList = orderRepository.findAll();
		return (orderList == null) ? Collections.emptyList():orderList;
	
	}

	@Override
	public Optional<Order> getById(Optional<Integer> orderId) {
		
		if (orderId.isPresent()) {
			return orderRepository.findById(orderId.get());
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<BigDecimal> getAverageOrderByDay(Optional<Date> day) {
		if (day.isPresent()) {
			return orderRepository.getAverageOrderByDay(day);
		}	
		return Optional.empty();
	}

	@Override
	public Optional<Long> getQuantityOfOrdersByDay(Optional<Date> day) {
		if (day.isPresent()) {
			return orderRepository.getQuantityOfOrdersByDay(day);
		}	
		return Optional.empty();
	}

}
