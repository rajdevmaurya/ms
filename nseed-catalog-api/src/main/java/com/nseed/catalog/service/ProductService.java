package com.nseed.catalog.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nseed.catalog.api.model.ProductRequest;
import com.nseed.catalog.api.model.ProductRequestSummary;
import com.nseed.catalog.entity.Product;

public interface ProductService {
	
	 List<ProductRequestSummary> getProductRequestSummaryData(String q,Integer page,Integer size);
	
	 ProductRequest getProductById(Long id);
	
	 void createProduct(ProductRequest productRequest);
	
	 void updateProduct(ProductRequest productRequest);
	 
	 Page<Product> getProductData(String q,Integer page,Integer size,String sortBy);
	
}