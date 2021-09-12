package com.deepika.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.retail.bean.Customer;
import com.retail.model.service.CustomerService;

@SpringBootApplication(scanBasePackages = "com.retail")
@EntityScan(basePackages = "com.retail.bean")
@EnableJpaRepositories(basePackages = "com.retail.model.persistence")
@EnableEurekaClient
public class OrderServiceConsumerMvcDemoApplication implements CommandLineRunner{

	@Autowired
	CustomerService customerService;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceConsumerMvcDemoApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		//customerService.insertCustomer(new Customer("Deepika","123456","deepika@gmail.com","Mumbai,India"));
		
	}
}
