package com.microservices.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.v1.bean.LimitConfiguration;
import com.microservices.v1.service.LimitsConfigurationService;

@RestController
@RequestMapping("/api")
public class LimitsConfigurationController {

	@Autowired
	private LimitsConfigurationService limitsConfigurationService;

	@GetMapping("/limits")
	public LimitConfiguration getLimitsFromConfigurations() {
		return limitsConfigurationService.getConfigurationForLimits();
	}
}
