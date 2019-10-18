package com.mygameshop.api.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mygameshop.api.persistence.model.Product;
import com.mygameshop.api.persistence.repository.ProductRepository;
import com.mygameshop.api.service.ProductService;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
	@Override
	public List<Product> list() {
		
		List<Product> productList = productRepository.findAll();
		return (productList == null) ? Collections.emptyList():productList;
		
	}

	@Override
	public Optional<Product> getById(Optional<Integer> productId) {

		if (productId.isPresent()) {
			return productRepository.findById(productId.get());
		} else {
			return Optional.empty();
		}	
	}

}
