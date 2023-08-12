package com.nseed.customer.delegate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nseed.customer.api.CustomerApiDelegate;
import com.nseed.customer.api.model.CustomerRequest;
import com.nseed.customer.api.model.CustomerRequestSummary;
import com.nseed.customer.entity.Customer;
import com.nseed.customer.service.CustomerService;

@Service
public class CustomerApiDelegateImpl implements CustomerApiDelegate {
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	public  ResponseEntity<Void> createCustomer(CustomerRequest productRequest) {
		         customerService.createCustomer(productRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
	
	@Override
	public  ResponseEntity<Void> updateCustomer(CustomerRequest productRequest) {
		         customerService.updateCustomer(productRequest);
        return new ResponseEntity<>(HttpStatus.OK);

    }

	@Override
	public ResponseEntity<List<CustomerRequestSummary>> getCustomerSummaryData(String q,Integer page, Integer size){
		List<CustomerRequestSummary> psdList=null;
		psdList=   customerService.getCustomerRequestSummaryData(q,page, size);
	    return new ResponseEntity<>(psdList,HttpStatus.OK);
	    }
	@Override
	public ResponseEntity<CustomerRequest> fetchCustomerRequest(Long requestId) {
		 return new ResponseEntity<>(customerService.getCustomerById(requestId),HttpStatus.OK);
	}
	
	
	  @Override public ResponseEntity<Page> filterCustomerSummaryData(Integer pageNumber,Integer pageSize,String q, String sortBy){
		  Page<Customer> psdList=null; psdList= customerService.getCustomerData(q,pageNumber, pageSize,sortBy); 
		  return new ResponseEntity<>(psdList,HttpStatus.OK); }
}

