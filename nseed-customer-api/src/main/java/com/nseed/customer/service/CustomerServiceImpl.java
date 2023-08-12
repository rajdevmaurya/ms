package com.nseed.customer.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.nseed.customer.api.model.CustomerRequest;
import com.nseed.customer.api.model.CustomerRequestSummary;
import com.nseed.customer.entity.Customer;
import com.nseed.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Page<Customer> getCustomerData(String q, Integer pageNo, Integer pageSize, String sortBy) {
		Page<Customer> products = null;
		if (sortBy == null) {
			sortBy = "customerId";
		}
		Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
		Pageable pageable = PageRequest.of((pageNo - 1), pageSize, sort);
		if (q != null) {
			products = customerRepository.searchCustomerData(q,pageable);
		} else {
			products = customerRepository.findAll(pageable);
		}
		return products;
	}
	
	public List<CustomerRequestSummary> getCustomerRequestSummaryData(String q, Integer pageNo, Integer pageSize) {
		  Pageable pageable = PageRequest.of((pageNo-1), pageSize);
		  Page<Customer> products= customerRepository.findAll(pageable);
		  List<Customer> pDataList=products.getContent();
		    List<CustomerRequestSummary> data=new ArrayList<>();
		    for (Customer p : pDataList) {
		    	CustomerRequestSummary psr=new CustomerRequestSummary();
		    	psr.setName(p.getName());
		    	data.add(psr);
		    }
			return data;
	}

	@Override
	public CustomerRequest getCustomerById(Long requestId) {
		      Customer p= customerRepository.findByCustomerId(requestId);
		        CustomerRequest prs=new CustomerRequest();
		        prs.setEmail(p.getDescription());
		return prs;
	}
	@Override
	public void createCustomer(CustomerRequest p) {
		   Customer prod = Customer.builder()
				.name(p.getName())
				.description(p.getEmail())
				.build();
		customerRepository.save(prod);
	}
	
	@Override
	public void updateCustomer(CustomerRequest p) {
		    Customer prod= customerRepository.findByCustomerId(p.getRequestId());
	    	prod.setName(p.getName());
	    	prod.setDescription(p.getEmail());
	    	customerRepository.save(prod);
	}


}
