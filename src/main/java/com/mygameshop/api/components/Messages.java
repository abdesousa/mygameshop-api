/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygameshop.api.components;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;

@Configuration
public class Messages {

	@Autowired
	private MessageSource messageSource;

	private MessageSourceAccessor accessor;

	@PostConstruct
	private void init() {
		//messageSource.setBasename("/WEB-INF/messages");
		accessor = new MessageSourceAccessor(messageSource);
		// accessor = new MessageSourceAccessor(messageSource, new Locale("pt", "BR"));
		//accessor = new MessageSourceAccessor(messageSource, new Locale("en","US"));
	}

	public String get(String code) {
		return accessor.getMessage(code);
	}

}