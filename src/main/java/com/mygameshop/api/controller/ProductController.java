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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="product", description="Operations pertaining to products in My Game Shop Online Store")
@CrossOrigin()
@RestController
public class ProductController {
	
    private Messages messages;
    private ProductService service;
    private ModelMapper modelMapper;
   
    @Autowired
    public ProductController(ProductService service,ModelMapper modelMapper, Messages messages) {
        this.service = service;
        this.modelMapper = modelMapper;
        this.messages = messages;
    }    
    
    @ApiOperation(value = "View a list of available products", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "002 - Product list is empty."),

    })
    @GetMapping("/product")
    @ResponseBody
    public ResponseEntity<?> list() {
    	
    	List<Product> products = service.list();
    	  
    	if (!products.isEmpty()) {  		
    		
    		return new ResponseEntity<List<MainDTO>>(
    				products.stream().map(s -> convertToDto(s)).collect(Collectors.toList()), HttpStatus.OK); 
    		
    	} else {
    		
    		return new ResponseEntity<MainDTO>(new ErrorDTO(messages.get("msg.productlist.empty.code"),messages.get("msg.productlist.empty.detail")), HttpStatus.BAD_REQUEST); 

    	}
    }

    @ApiOperation(value = "View the information of a product", response = ProductDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "001 - Product doesn't exist!"),

    })
    @GetMapping("/product/{id}")
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
    	
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
