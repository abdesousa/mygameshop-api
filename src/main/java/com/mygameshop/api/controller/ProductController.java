package com.mygameshop.api.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mygameshop.api.components.Messages;
import com.mygameshop.api.dto.ErrorDTO;
import com.mygameshop.api.dto.MainDTO;
import com.mygameshop.api.dto.ProductDTO;
import com.mygameshop.api.persistence.model.Product;
import com.mygameshop.api.service.ProductService;

@CrossOrigin()
@RestController
public class ProductController {
	
	
    @Autowired
    private Messages messages;
	
    @Autowired
    private ModelMapper modelMapper;
	
    @Autowired
    private ProductService service;


    @GetMapping("/product")
    @ResponseBody
    public ResponseEntity<?> getProducts() {
    	
    	List<Product> products = service.list();
    	  
    	if (!products.isEmpty()) {  		
    		
    		return new ResponseEntity<List<MainDTO>>(
    				products.stream().map(s -> convertToDto(s)).collect(Collectors.toList()), HttpStatus.OK); 
    		
    	} else {
    		
    		return new ResponseEntity<MainDTO>(new ErrorDTO(messages.get("msg.productlist.empty.code"),messages.get("msg.productlist.empty.detail")), HttpStatus.BAD_REQUEST); 

    	}
    }

    @GetMapping("/product/{id}")
    @ResponseBody
    public ResponseEntity<?> getProduct(@PathVariable("id") Integer id) {
    	
    	Optional<Product> product = service.getById(Optional.ofNullable(id));
    	  
    	if (product.isPresent()) {  		
    		
    		return new ResponseEntity<MainDTO>(convertToDto(product.get()), HttpStatus.OK); 
    		
    	} else {
    		
    		return new ResponseEntity<MainDTO>(new ErrorDTO(messages.get("msg.product.notexists.code"),messages.get("msg.product.notexists.detail")), HttpStatus.BAD_REQUEST); 
    		
    	}
    }
	    
    private ProductDTO convertToDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
    
    private Product convertToEntity(ProductDTO dto) throws ParseException {
        return modelMapper.map(dto, Product.class);
    }
}
