package com.deepika.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShareDemoGatewayapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareDemoGatewayapiApplication.class, args);
	}

}
