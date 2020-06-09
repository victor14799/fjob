package com.example.fjob.service.controller.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fjob.service.service.hello.HelloService;

@RestController
@RequestMapping("fjob/v1")
public class HelloController {

	private HelloService helloService;

	@Autowired
	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@GetMapping("/hello")
	public int hello() {
		return helloService.hello();
	}
}
