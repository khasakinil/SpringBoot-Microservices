package com.microservices.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.v1.bean.LimitConfiguration;
import com.microservices.v1.config.LimitsConfigurationProperties;

@Service
public class LimitsConfigurationService {

	@Autowired
	private LimitsConfigurationProperties limitsConfigurationProperties;

	public LimitConfiguration getConfigurationForLimits() {
		return new LimitConfiguration(limitsConfigurationProperties.getMaximum(),
				limitsConfigurationProperties.getMinimum());
	}

}
