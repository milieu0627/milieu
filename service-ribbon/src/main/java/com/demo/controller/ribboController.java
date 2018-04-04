package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.ribboService;

/**
 * 服务消费者控制层
 * @author mills
 *
 */
@RestController
public class ribboController {
	@Autowired
	private ribboService ribboService;
	@RequestMapping("/hi")
	public String sayHi(@RequestParam String name) {
		return ribboService.hiService(name);
	}
}
