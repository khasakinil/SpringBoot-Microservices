package com.restful.webservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webservice.bean.SomeBean;

@RestController
@RequestMapping("/api")
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean filtering() {
		return new SomeBean("FirstName", "LastName", "MobileNumber");
	}

	@GetMapping("/filtering/list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("FirstName", "LastName", "MobileNumber"),
				new SomeBean("Nilakanth", "Khasaki", "9420091520"), new SomeBean("Mahadeo", "Waghadari", "9730146142"),
				new SomeBean("Suraj", "Bharamshetti", "9766802316"), new SomeBean("Raj", "Sawalagi", "7276751057"));
	}
}
