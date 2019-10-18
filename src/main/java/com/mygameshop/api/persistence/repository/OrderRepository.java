package com.mygameshop.api.persistence.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mygameshop.api.persistence.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("select avg(o.order_vl) from tbl_order o where o.order_dt = ?")
	Optional<BigDecimal> getAverageOrderByDay(Optional<Date> day);
	
	@Query("select count(o.order_vl) from tbl_order o where o.order_dt = ?")
	Optional<Long> getQuantityOfOrdersByDay(Optional<Date> day);
	
}