package com.spring.FirstSpringBootApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.FirstSpringBootApp.config.CurrencyServiceConfiguration;

@RestController
@RequestMapping("/currency")
public class CurrencyConfigurationController {

	@Autowired
	private CurrencyServiceConfiguration currencyServiceConfiguration;

	@RequestMapping("/configuration")
	public CurrencyServiceConfiguration retrieveAllCourses() {
		return currencyServiceConfiguration;
	}

}
