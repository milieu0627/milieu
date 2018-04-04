package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 服务消费者
 * @author mills
 *
 */
@Service
public class ribboService {
	@Autowired
	private RestTemplate restTemplate;
	@HystrixCommand(fallbackMethod="error")
    public String hiService(String name) {
		int a=5/0;
        return restTemplate.getForObject("http://service-hi/hi?name="+name,String.class);
    }
	
	String error(String name) {
		return "喔豁!"+name+" 出错了，进入断路器方法";
	}
}
