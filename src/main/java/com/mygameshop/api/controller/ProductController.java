package com.mygameshop.api.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mygameshop.api.dto.MainDTO;
import com.mygameshop.api.dto.ProductDTO;
import com.mygameshop.api.persistence.model.Order;
import com.mygameshop.api.persistence.model.Product;
import com.mygameshop.api.service.ProductService;

@CrossOrigin()
@RestController
@RequestMapping("/product")
public class ProductController {
	
	
    @Autowired
    private ModelMapper modelMapper;
	
    private ProductService service;

    @Autowired
    public void setProductService(ProductService service) {
        this.service = service;
    }    
    

    @GetMapping("/{id}")
    @ResponseBody
    public MainDTO getProduct(@PathVariable("id") Integer id) {
    	
    	Optional<Product> product = service.getById(Optional.ofNullable(id));
    	  
    	if (product.isPresent()) {
    		return convertToDto(product.get());
    	} else {
    		return new ErrorDTO();
            responseError.setMessage(messages.get("error.unexpected.detail") + "["+e.getMessage()+"]");
            responseError.setId(messages.get("error.unexpected.code"));
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
    
    private ProductDTO convertToDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
    
    private Product convertToEntity(ProductDTO dto) throws ParseException {
        return modelMapper.map(dto, Product.class);
    }
}
