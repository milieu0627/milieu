package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//开启服务发现
@EnableEurekaClient
//开启路由功能
@EnableZuulProxy
public class ZuulApplication {
	//开启日志
	private final static Logger logger = LoggerFactory.getLogger(ZuulApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
		logger.info("进入路由模块，启动路由功能");
	}
}
