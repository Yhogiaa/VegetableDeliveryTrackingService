package com.pdt.product.controllers;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pdt.product.dtos.ProductDto;
import com.pdt.product.services.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
    private static final String PRODUCT_ADDR = "/product";
    private static final String PRODUCT_BY_ID_ADDR = PRODUCT_ADDR + "/{id}";
    private static final String PRODUCT_CHECK_EXIST_ADDR = "/check";
    private static final String PRODUCT_PRICE_CHECK_EXIST_ADDR = "/price_check";

    
    private final ProductService productService;
    
    private ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(PRODUCT_ADDR)
    private ResponseEntity<List<ProductDto>> findAll() {
        List<ProductDto> productList = productService.findAll();
        return ResponseEntity.ok().body(productList);
    }
    
    @PostMapping(PRODUCT_ADDR)
    public ResponseEntity<ProductDto> insert(@RequestBody ProductDto orderDto) {
        orderDto = productService.create(orderDto);
        return ResponseEntity.ok().body(orderDto);
    }
    
    @PutMapping(PRODUCT_BY_ID_ADDR)
    public ResponseEntity<ProductDto> update(@PathVariable("id") Long id,@RequestBody ProductDto data) {
    	ProductDto updateEntity = productService.update(id, data);
		return ResponseEntity.ok().body(updateEntity);
    }
    
    @DeleteMapping(PRODUCT_BY_ID_ADDR)
	public ResponseEntity<String> delete(@PathVariable Long id) {
    	productService.delete(id);
		return ResponseEntity.ok().body("Delete Success");
	}
    
	@GetMapping(PRODUCT_BY_ID_ADDR)
	public ResponseEntity<ProductDto> getById(@PathVariable("id") Long id) {
		ProductDto getDataById = productService.findById(id);
		return ResponseEntity.ok().body(getDataById);
	}
	
	@GetMapping(PRODUCT_CHECK_EXIST_ADDR)
	public ResponseEntity<String> cheackExist(@RequestParam("name") String name) {
		String exist = productService.checkExist(name);
		return ResponseEntity.ok().body(exist);
	}
	
	@GetMapping(PRODUCT_PRICE_CHECK_EXIST_ADDR)
	public ResponseEntity<List<ProductDto>> priceCheck(@RequestParam("price") BigInteger price) {
		List<ProductDto> productList = productService.bigPriceCheck(price);
		return ResponseEntity.ok().body(productList);
	}
    
}
