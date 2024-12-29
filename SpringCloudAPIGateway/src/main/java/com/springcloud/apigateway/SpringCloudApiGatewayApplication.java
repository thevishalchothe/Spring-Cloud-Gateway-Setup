package com.springcloud.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // Enable Eureka Client to register with Eureka Server
public class SpringCloudApiGatewayApplication {

	// Create a logger instance
	private static final Logger logger = LoggerFactory.getLogger(SpringCloudApiGatewayApplication.class);

	public static void main(String[] args) {

		System.out.println("Spring Cloud API Gateway Server is starting...");

		SpringApplication.run(SpringCloudApiGatewayApplication.class, args);

		logger.info("Spring Cloud API Gateway Server has started successfully!");

	}

}
