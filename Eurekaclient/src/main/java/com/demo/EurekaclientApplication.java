package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 消息提供者
 * @author mills
 *
 */
@SpringBootApplication
//授权消息提供者
@EnableEurekaClient
public class EurekaclientApplication {
	private final static Logger logger=LoggerFactory.getLogger(EurekaclientApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EurekaclientApplication.class, args);
		logger.info("消息服务 提供者启动");
	}
}
