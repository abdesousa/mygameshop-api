package com.mygameshop.api.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.mygameshop.api.persistence.model.Order;

public interface OrderService {

    public void save(Optional<Order> order);
    
    public List<Order> list();
    
    public Optional<Order> getById(Optional<Integer> orderId);
    
    public Optional<BigDecimal> getAverageOrderByDay(Optional<Date> day); 
    
    public Optional<Long> getQuantityOfOrdersByDay(Optional<Date> day); 
}