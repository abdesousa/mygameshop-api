package com.mygameshop.api.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;

import com.mygameshop.api.persistence.model.Product;
import com.mygameshop.api.persistence.repository.ProductRepository;
import com.mygameshop.api.service.ProductService;

public class ProductServiceImplTest {

 	private  ProductRepository productRepository;
 	private  ProductService service;

    public ProductServiceImplTest() {

        this.productRepository = Mockito.mock(ProductRepository.class);	        
        this.service = new ProductServiceImpl(this.productRepository);

    }
 	
    @Test
    public void givenListWhenHaveProductsThenReturnAllValues() {

    	//Given
        List<Product> productMockedList = new ArrayList<Product>();          
        
        productMockedList.add(new Product(1, "Product 1", BigDecimal.valueOf(60.0)));
        productMockedList.add(new Product(2, "Product 2", BigDecimal.valueOf(90.0)));

        Mockito.when(productRepository.findAll()).thenReturn(productMockedList);

        List<Product> productReturned = this.service.list();

        assertEquals(Integer.valueOf(1), productReturned.get(0).getProductId());
        assertEquals("Product 1", productReturned.get(0).getProductName());
        assertEquals(BigDecimal.valueOf(60.0), productReturned.get(0).getProductValue());
        
        assertEquals(Integer.valueOf(2), productReturned.get(1).getProductId());
        assertEquals("Product 2", productReturned.get(1).getProductName());
        assertEquals(BigDecimal.valueOf(90.0), productReturned.get(1).getProductValue());

    }
    
    @Test
    public void givenListWhenEmptyProductTableThenReturnEmptyList() {

        Mockito.when(productRepository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(this.service.list().isEmpty());
    }

    
    @Test
    public void givenProductIdWhenExistsProductThenReturnProductInformation() {

    	Optional<Integer> id = Optional.of(4);
        Optional<Product> productmocked = Optional.of(new Product(4, "Product 4", BigDecimal.valueOf(60.0)));          
        
        Mockito.when(productRepository.findById(id.get())).thenReturn(productmocked);

        Optional<Product> productReturned = this.service.getById(id);

        assertEquals(Integer.valueOf(4), productReturned.get().getProductId());
        assertEquals("Product 4", productReturned.get().getProductName());
        assertEquals(BigDecimal.valueOf(60.0), productReturned.get().getProductValue());
        
    }

    @Test
    public void givenListWhenEmptyProductTableThenReturnEmpty() {

    	Optional<Integer> id = Optional.of(new Integer(1));

        Mockito.when(productRepository.findById(id.get())).thenReturn(Optional.empty());        
        assertEquals(Optional.empty(), this.service.getById(id));
        
    }    

}
