package com.example.comtrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.comtrade.entity.Hello;
import com.example.comtrade.service.HelloService;

@RestController
@RequestMapping(value = "/api")
public class HelloRestController {
	
	@Autowired
	HelloService helloService;
	
	// http://localhost:8080/api/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHelloWorld() {
		
		return "Hello World";
	}	

	// http://localhost:8080/api/getAllHellos
	@RequestMapping(value = "/getAllHellos", method = RequestMethod.GET)
	public List<Hello> getAllHellos() 
	{	
		
		List<Hello> list = helloService.getAllHellos();

		
		return list;
	}
	// http://localhost:8080/api/getHello/ and some id ....
	@RequestMapping(value = "/getHello/{id}", method = RequestMethod.GET)
	public Hello getCategoryById(@PathVariable long id) {
		return helloService.getHelloById(id);
	}
}
