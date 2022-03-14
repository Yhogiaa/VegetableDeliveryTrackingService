package com.pdt.product.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.pdt.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT obj FROM Product obj WHERE obj.price>:price ORDER BY obj.name ASC")
    List<Product> bigPriceCheck(@RequestParam("price") BigInteger price);
    
    @Query(value = "select case \r\n" + 
			"            when exists (select 1 \r\n" + 
			"                        from tb_product a \r\n" + 
			"                        where a.name = :name) \r\n" + 
			"            then 'Y'\r\n" + 
			"            else 'N' \r\n" + 
			"        end as name_exists\r\n" + 
			"from dual" , nativeQuery = true)
    String existsByName(@RequestParam("name") String name);
    
}
