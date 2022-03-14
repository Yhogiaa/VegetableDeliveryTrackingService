package com.pdt.product.services;

import java.math.BigInteger;
import java.util.List;

import com.pdt.product.dtos.ProductDto;

public interface ProductService {
	
	List<ProductDto> findAll();
	ProductDto create(ProductDto productDto);
	ProductDto update(Long id, ProductDto productDto);
    void delete(Long id);
    ProductDto findById(Long id);
	String checkExist(String name);
	List<ProductDto> bigPriceCheck(BigInteger price);

}
