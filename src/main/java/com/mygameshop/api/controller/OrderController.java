package com.mygameshop.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mygameshop.api.dto.ProductDTO;
import com.mygameshop.api.persistence.model.Product;

public class OrderController {


    @PostMapping
    public void save(@RequestBody ProductDTO productDto) {
    	
    	Product product = this.convertToEntity(productDto);
    	this.service.save(product);
    	
	}
	
}
