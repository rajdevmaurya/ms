package com.nseed.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nseed.catalog.entity.Order;
import com.nseed.catalog.entity.OrderItem;

import java.util.List;

/**
 * Created by mpjoshi on 10/10/19.
 */

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrder(Order order);
}
