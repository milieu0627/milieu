package com.demo.server;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient("SERVICE-HI")
public interface FegenServer {
	@RequestMapping(value = "/hi" , method =RequestMethod.GET)
	String sayHi(@RequestParam(value="name") String name);
}
