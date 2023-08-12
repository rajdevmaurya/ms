package com.nseed.customer.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nseed.customer.api.model.CustomerRequest;
import com.nseed.customer.api.model.CustomerRequestSummary;
import com.nseed.customer.entity.Customer;

public interface CustomerService {
	
	 List<CustomerRequestSummary> getCustomerRequestSummaryData(String q,Integer page,Integer size);
	
	 CustomerRequest getCustomerById(Long id);
	
	 void createCustomer(CustomerRequest productRequest);
	
	 void updateCustomer(CustomerRequest productRequest);
	 
	 Page<Customer> getCustomerData(String q,Integer page,Integer size,String sortBy);
	
}