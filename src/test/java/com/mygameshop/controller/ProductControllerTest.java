package com.mygameshop.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import com.mygameshop.api.components.Messages;
import com.mygameshop.api.controller.ProductController;
import com.mygameshop.api.persistence.model.Product;
import com.mygameshop.api.service.ProductService;

public class ProductControllerTest {

 	private  ProductService service;
 	private  ProductController controller;    
    private ModelMapper modelMapper;
    private Messages messages;


    public ProductControllerTest() {
    	this.messages = Mockito.mock(Messages.class);	        
        this.modelMapper = new ModelMapper();
        this.service = Mockito.mock(ProductService.class);	        
        this.controller = new ProductController(this.service, this.modelMapper, this.messages);

    }
 	
     
    @Test
    public void givenProductIdWhenExistsProductThenReturnOkStatus() {

    	Optional<Integer> id = Optional.of(4);
    	Optional<Product> product = Optional.of(new Product(4, "Product 4", BigDecimal.valueOf(60.0),new Date(),"teste",new Date(),"teste"));        
        Mockito.when(this.service.getById(id)).thenReturn(product);        
        assertEquals(HttpStatus.OK,this.controller.getById(id.get()).getStatusCode().OK);
        
    }


    @Test
    public void givenProductIdWhenNotExistsProductThenReturnBadRequestStatus() {

    	Optional<Integer> id = Optional.of(4);
        
        Mockito.when(this.service.getById(id)).thenReturn(Optional.empty());
        Mockito.when(messages.get("msg.product.notexists.code")).thenReturn("XXXX");
        Mockito.when(messages.get("msg.product.notexists.detail")).thenReturn("Detail Message");
        
        assertEquals(HttpStatus.BAD_REQUEST,this.controller.getById(id.get()).getStatusCode().BAD_REQUEST);

        
    }
}
