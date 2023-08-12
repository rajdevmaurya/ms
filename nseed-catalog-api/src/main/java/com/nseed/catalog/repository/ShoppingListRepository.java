package com.nseed.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nseed.catalog.entity.ShoppingList;
import com.nseed.catalog.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by mpjoshi on 9/29/19.
 */

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer>{

    Optional<ShoppingList> findByCustomer(User user);

    @Query(value = "SELECT sl from ShoppingList sl where sl.customer.id = :customerId")
    List<ShoppingList> findByCustomerId(@Param("customerId") Integer customerId);

    @Query(value = "SELECT sl from ShoppingList sl where sl.name = :name AND sl.customer.id = :customerId")
    Optional<ShoppingList> findByCustomerIdAndName(
            @Param("name") String name,
            @Param("customerId") Integer customerId);


}
