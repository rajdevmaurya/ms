package com.nseed.catalog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nseed.catalog.entity.Order;
import com.nseed.catalog.entity.User;

 

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    List<Order> findByUser(User user);
}
