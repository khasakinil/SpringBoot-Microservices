package com.restful.webservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.restful.webservice.bean.SomeBeanDynamicFiltering;
import com.restful.webservice.bean.SomeBeanStaticFiltering;

@RestController
@RequestMapping("/api")
public class FilteringController {

	@GetMapping("/static/filtering")
	public SomeBeanStaticFiltering staticFiltering() {
		return new SomeBeanStaticFiltering("FirstName", "LastName", "MobileNumber");
	}

	@GetMapping("/static/filtering/list")
	public List<SomeBeanStaticFiltering> staticFilteringList() {
		return Arrays.asList(new SomeBeanStaticFiltering("FirstName", "LastName", "MobileNumber"),
				new SomeBeanStaticFiltering("Nilakanth", "Khasaki", "9420091520"),
				new SomeBeanStaticFiltering("Mahadeo", "Waghadari", "9730146142"),
				new SomeBeanStaticFiltering("Suraj", "Bharamshetti", "9766802316"),
				new SomeBeanStaticFiltering("Raj", "Sawalagi", "7276751057"));
	}

	@GetMapping("/dynamic/filtering")
	public MappingJacksonValue dynamicFiltering() {

		SomeBeanDynamicFiltering someBean = new SomeBeanDynamicFiltering("FirstName", "LastName", "MobileNumber");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "mobileNumber");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;
	}

	@GetMapping("/dynamic/filtering/list")
	public MappingJacksonValue dynamicFilteringList() {

		List<SomeBeanDynamicFiltering> someBeanList = Arrays.asList(
				new SomeBeanDynamicFiltering("FirstName", "LastName", "MobileNumber"),
				new SomeBeanDynamicFiltering("Nilakanth", "Khasaki", "9420091520"),
				new SomeBeanDynamicFiltering("Mahadeo", "Waghadari", "9730146142"),
				new SomeBeanDynamicFiltering("Suraj", "Bharamshetti", "9766802316"),
				new SomeBeanDynamicFiltering("Raj", "Sawalagi", "7276751057"));

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeanList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("lastName", "mobileNumber");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;
	}
}
