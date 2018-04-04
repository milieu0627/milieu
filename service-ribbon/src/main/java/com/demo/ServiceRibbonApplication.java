package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//授权消费者服务
@EnableDiscoveryClient
//开启断路器
@EnableHystrix
public class ServiceRibbonApplication {
	private final static Logger logger=LoggerFactory.getLogger(ServiceRibbonApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
		logger.info("服务消费者启动");
	}
	//开启负载均衡
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
