package com.nseed.product.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nseed.product.api.model.ProductRequest;
import com.nseed.product.api.model.ProductRequestSummary;
import com.nseed.product.entity.Product;

public interface ProductService {
	
	 List<ProductRequestSummary> getProductRequestSummaryData(String q,Integer page,Integer size);
	
	 ProductRequest getProductById(Long id);
	
	 void createProduct(ProductRequest productRequest);
	
	 void updateProduct(ProductRequest productRequest);
	 
	 Page<Product> getProductData(String q,Integer page,Integer size,String sortBy);
	
}