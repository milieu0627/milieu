package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//授权注册中心
@EnableEurekaServer
public class EurekaserverApplication {
	private final static Logger logger=LoggerFactory.getLogger(EurekaserverApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EurekaserverApplication.class, args);
		logger.info("服务注册中心");
	}
}
