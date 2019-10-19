package com.mygameshop.api.service;

import java.util.List;
import java.util.Optional;

import com.mygameshop.api.persistence.model.Product;

public interface ProductService {

	public List<Product> list();
	
	public Optional<Product> getById(Optional<Integer> productId);
	
}
