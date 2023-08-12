package com.nseed.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nseed.catalog.entity.ShoppingCart;

import java.util.Optional;

/**
 * Created by mpjoshi on 10/10/19.
 */

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{

    Optional<ShoppingCart> findByUserId(Integer customerId);

}
