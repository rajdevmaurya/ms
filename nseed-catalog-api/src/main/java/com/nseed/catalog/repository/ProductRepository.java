package com.nseed.catalog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nseed.catalog.entity.Product;

 
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

    //Page<Product> findByCategoryId(Integer category_id, Pageable pageable);
    
    Product  findByProductId(Long productId);
    
    @Query("SELECT t FROM Product t WHERE " +
            "LOWER(t.name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.sku) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    Page<Product> searchProductData(@Param("searchTerm") String searchTerm, Pageable pageable);

}
