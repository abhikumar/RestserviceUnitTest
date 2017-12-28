package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;

@RestController
@RequestMapping("/hello")
public class RestService {
	@Autowired
	CustService custService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Customer get() {
		return custService.getCust();

	}
}
