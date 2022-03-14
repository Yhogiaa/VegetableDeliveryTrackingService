package com.pdt.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pdt.product.configs.DaoSpringBootConfig;

@SpringBootApplication
@Import({ DaoSpringBootConfig.class })
@EntityScan({ "com.pdt.product.entities" })
@EnableJpaRepositories({ "com.pdt.product.repositories" })
@ComponentScan({ "com.pdt.product" })
public class ProductDeliveryTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDeliveryTrackingApplication.class, args);
	}

}
