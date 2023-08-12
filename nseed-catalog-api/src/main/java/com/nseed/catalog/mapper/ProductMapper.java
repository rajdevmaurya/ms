package com.nseed.catalog.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.core.convert.converter.Converter;
import com.nseed.catalog.api.model.ProductRequestSummary;
import com.nseed.catalog.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper extends Converter<Product,  ProductRequestSummary> { 
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class ); 
	ProductRequestSummary  productToProductRequestSummary(Product product);    
}