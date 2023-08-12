package com.nseed.product.delegate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.nseed.product.api.ProductApiDelegate;
import com.nseed.product.api.model.ProductRequest;
import com.nseed.product.api.model.ProductRequestSummary;
import com.nseed.product.entity.Product;
import com.nseed.product.service.ProductService;

@Service
public class ProductApiDelegateImpl implements ProductApiDelegate {
	
	@Autowired
	private ProductService productService;
	
	@Override
	public  ResponseEntity<Void> createProduct(ProductRequest productRequest) {
		         productService.createProduct(productRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
	
	@Override
	public  ResponseEntity<Void> updateProduct(ProductRequest productRequest) {
		         productService.updateProduct(productRequest);
        return new ResponseEntity<>(HttpStatus.OK);

    }

	@Override
	public ResponseEntity<List<ProductRequestSummary>> getProductSummaryData(String q,Integer page, Integer size){
		List<ProductRequestSummary> psdList=null;
		psdList=   productService.getProductRequestSummaryData(q,page, size);
	    return new ResponseEntity<>(psdList,HttpStatus.OK);
	    }
	@Override
	public ResponseEntity<ProductRequest> fetchProductRequest(Long requestId) {
		 return new ResponseEntity<>(productService.getProductById(requestId),HttpStatus.OK);
	}
	
	
	  @Override public ResponseEntity<Page> filterProductSummaryData(Integer pageNumber,Integer pageSize,String q, String sortBy){
		  Page<Product> psdList=null; psdList= productService.getProductData(q,pageNumber, pageSize,sortBy); 
		  return new ResponseEntity<>(psdList,HttpStatus.OK); }
}

