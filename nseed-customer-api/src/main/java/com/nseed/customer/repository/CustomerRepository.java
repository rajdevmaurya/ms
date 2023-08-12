package com.nseed.customer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nseed.customer.entity.Customer;
import com.nseed.customer.entity.Customer;

/**
 * Created by mpjoshi on 10/31/19.
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	


    Page<Customer> findByNameContainingIgnoreCase(String name, Pageable pageable);

    
    Customer  findByCustomerId(Long customerId);
    
    @Query("SELECT t FROM Customer t WHERE " +
            "LOWER(t.name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.description) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.email) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    Page<Customer> searchCustomerData(@Param("searchTerm") String searchTerm, Pageable pageable);


}
