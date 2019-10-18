package com.mygameshop.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mygameshop.api.persistence.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}