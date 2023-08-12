package com.nseed.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nseed.product.entity.Category;

 
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
}
