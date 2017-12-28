package com;

import org.springframework.stereotype.Service;

import com.model.Customer;

@Service
public class CustService {

	public Customer getCust() {
		Customer cust = new Customer(1,4,"abhi");
		return cust;
	}
}
