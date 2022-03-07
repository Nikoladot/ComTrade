package com.example.comtrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.comtrade.service.HelloService;

@Controller
@RequestMapping(value = "/HTML")
public class HelloHTMLController {
	
	@Autowired
	HelloService helloService;
	

	// http://localhost:8080/HTML
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getHelloPage() {
		
		return "HelloWorld";
	}

	
	
}
