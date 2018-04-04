package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FegenApplication {
	//开启日志
	private final static Logger logger=LoggerFactory.getLogger(FegenApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FegenApplication.class, args);
		logger.info("启动fegen服务");
	}
}
