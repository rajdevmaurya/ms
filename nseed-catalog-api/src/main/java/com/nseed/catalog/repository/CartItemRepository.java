package com.nseed.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nseed.catalog.entity.CartItem;

/**
 * Created by mpjoshi on 10/10/19.
 */

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
