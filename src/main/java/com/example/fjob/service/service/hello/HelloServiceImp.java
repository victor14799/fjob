package com.example.fjob.service.service.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fjob.lib.component.hello.HelloComponent;

@Service
public class HelloServiceImp implements HelloService {

	private HelloComponent helloComponent;

	@Autowired
	public HelloServiceImp(HelloComponent helloComponent) {
		this.helloComponent = helloComponent;
	}

	@Override
	public int hello() {
		return helloComponent.hello();
	}

}
