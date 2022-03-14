package com.pdt.product.dtos;

import java.math.BigInteger;
import com.pdt.product.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
	
	private final Long id;
    private final String name;
    private final BigInteger price;
    private final String stock;
    private final String location;
    private final String description;
    private final String imageUri;
    
    public ProductDto(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.stock = entity.getStock();
        this.location = entity.getLocation();
        this.description = entity.getDescription();
        this.imageUri = entity.getImageUri();
    }
    
   
}
