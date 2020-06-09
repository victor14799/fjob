package com.example.fjob.lib.component.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fjob.lib.mapper.hello.HelloMapper;

@Component
public class HelloComponentImp implements HelloComponent {

	private HelloMapper mapper;

	@Autowired
	public HelloComponentImp(HelloMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int hello() {
		return mapper.count();
	}

}
