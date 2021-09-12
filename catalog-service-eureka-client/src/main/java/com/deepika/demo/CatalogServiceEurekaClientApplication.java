package com.deepika.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.catalog")
@EnableEurekaClient
public class CatalogServiceEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceEurekaClientApplication.class, args);
	}

}
