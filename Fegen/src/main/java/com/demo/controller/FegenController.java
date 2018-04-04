package com.demo.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.server.FegenServer;

@RestController
public class FegenController {
	//开启日志
	private final static Logger logger=LoggerFactory.getLogger(FegenController.class);
	
	@Resource
	private FegenServer fegenServer;
	
	@RequestMapping(value ="/hi" ,method=RequestMethod.GET	)
	String sayHI(@RequestParam String name) {
		String result=fegenServer.sayHi(name);
		return result;
	}
}
