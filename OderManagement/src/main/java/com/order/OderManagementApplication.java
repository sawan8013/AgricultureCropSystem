package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.order.service.OrderServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableMongoRepositories
@EnableEurekaClient
@EnableSwagger2
public class OderManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OderManagementApplication.class, args);
	}
	
	

}
