package com.nseed.product.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.nseed.product.api.model.ProductRequest;
import com.nseed.product.api.model.ProductRequestSummary;
import com.nseed.product.entity.Product;
import com.nseed.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	
	public Page<Product> getProductData(String q, Integer pageNo, Integer pageSize, String sortBy) {
		Page<Product> products = null;
		if (sortBy == null) {
			sortBy = "productId";
		}
		Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
		Pageable pageable = PageRequest.of((pageNo - 1), pageSize, sort);
		if (q != null) {
			products = productRepository.searchProductData(q,pageable);
		} else {
			products = productRepository.findAll(pageable);
		}
		return products;
	}
	
	public List<ProductRequestSummary> getProductRequestSummaryData(String q, Integer pageNo, Integer pageSize) {
		  Pageable pageable = PageRequest.of((pageNo-1), pageSize);
		  Page<Product> products= productRepository.findAll(pageable);
		  List<Product> pDataList=products.getContent();
		    List<ProductRequestSummary> data=new ArrayList<>();
		    for (Product p : pDataList) {
		    	ProductRequestSummary psr=new ProductRequestSummary();
		    	psr.setRequestId(p.getProductId());
		    	psr.setName(p.getName());
		    	psr.setSku(p.getSku());
		    	if(p.getCategory()!=null)
		    	 psr.setCategory(p.getCategory().getName());
		    	psr.setActive(p.getActive());   
		    	psr.setPrice((Long)p.getPrice());   
		    	data.add(psr);
		    }
			return data;
	}

	@Override
	public ProductRequest getProductById(Long requestId) {
		      Product p= productRepository.findByProductId(requestId);
		        ProductRequest prs=new ProductRequest();
		        prs.setRequestId(p.getProductId());
		        prs.setName(p.getName());
		        prs.setDescription(p.getDescription());
		        prs.setSku(p.getSku());
		        prs.setCategory(p.getCategory().getName());
		        prs.setActive(p.getActive());   
		        prs.setPrice((Long)p.getPrice());   
		        prs.setImageUrl(p.getImageUrl());  
		        prs.setAvailableQuantities(p.getAvailableQuantities());    
		return prs;
	}
	@Override
	public void createProduct(ProductRequest p) {
		   Product prod = Product.builder()
				.name(p.getName())
				.description(p.getDescription())
				.sku(p.getSku())
				.active(p.getActive())
				.price((Long)p.getPrice())
				.imageUrl(p.getImageUrl())
				.availableQuantities(p.getAvailableQuantities())
				.build();
		productRepository.save(prod);
	}
	
	@Override
	public void updateProduct(ProductRequest p) {
		    Product prod= productRepository.findByProductId(p.getRequestId());
	    	prod.setName(p.getName());
	    	prod.setDescription(p.getDescription());
	    	prod.setSku(p.getSku());
	    	prod.setActive(p.getActive());   
	    	prod.setPrice((Long)p.getPrice());   
	    	prod.setImageUrl(p.getImageUrl());  
	    	prod.setAvailableQuantities(p.getAvailableQuantities()); 
	    	productRepository.save(prod);
	}


}
