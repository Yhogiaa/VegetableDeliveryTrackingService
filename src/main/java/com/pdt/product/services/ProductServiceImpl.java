package com.pdt.product.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pdt.product.dtos.ProductDto;
import com.pdt.product.entities.Product;
import com.pdt.product.repositories.ProductRepository;


public class ProductServiceImpl implements ProductService {
	
    @Autowired
    ProductRepository productRepository;

	@Override
	public List<ProductDto> findAll() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(ProductDto::new).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public ProductDto create(ProductDto productDto) {
		Product product = new Product(
				null, 
				productDto.getName(), 
				productDto.getPrice(), 
				productDto.getStock(), 
				productDto.getLocation(), 
				productDto.getDescription(), 
				productDto.getImageUri()
				);

		productRepository.save(product);

        return new ProductDto(product);
	}

	@Override
	public ProductDto update(Long id, ProductDto productDto) {
		Product newData = new Product();
        Optional<Product> oldData = productRepository.findById(id);

		newData = oldData.get();
		Product product = new Product(
				newData.getId(), 
				productDto.getName(), 
				productDto.getPrice(), 
				productDto.getStock(), 
				productDto.getLocation(), 
				productDto.getDescription(), 
				productDto.getImageUri()
				);

		productRepository.save(product);

        return new ProductDto(product);
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);

	}

	@Override
	public ProductDto findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new IllegalStateException("not found"));
        return new ProductDto(product);
	}

	@Override
	public String checkExist(String name) {
		return productRepository.existsByName(name);
	}

	@Override
	public List<ProductDto> bigPriceCheck(BigInteger price) {
		List<Product> productList = productRepository.bigPriceCheck(price);
		return productList.stream().map(ProductDto::new).collect(Collectors.toList());
	}

	
}
