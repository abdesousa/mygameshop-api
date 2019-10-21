package com.mygameshop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class MyGameShopApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyGameShopApplication.class, args);
	}

}
