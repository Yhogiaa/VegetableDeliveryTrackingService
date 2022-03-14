package com.pdt.product.configs;

import org.springframework.context.annotation.Bean;

import com.pdt.product.services.ProductService;
import com.pdt.product.services.ProductServiceImpl;

public class DaoSpringBootConfig {

	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}

}