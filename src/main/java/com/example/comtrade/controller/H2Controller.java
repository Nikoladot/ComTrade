	package com.example.comtrade.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.comtrade.entity.Hello;
import com.example.comtrade.service.HelloService;







@Controller
@RequestMapping(value = "/")
public class H2Controller {
	

	@Autowired
	HelloService helloService;
	
	
	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editHelloById(Model model, @PathVariable("id") Optional<Long> id) 
							
	{
		
		if (id.isPresent()) {
			Hello hello = helloService.getHelloById(id.get());
			model.addAttribute("hello", hello);
		} else {
			model.addAttribute("hello", new Hello());
		}
		
		
		return "add-edit-hello";
	}
	
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id) 
							
	{
		
		
		helloService.deleteHelloById(id);
		return "redirect:/";
	}

	@RequestMapping
	public String getAllHellos(Model model) 
	{	
		
		List<Hello> list = helloService.getAllHellos();

		model.addAttribute("hellos", list);
		
		return "list-hellos";
	}
	
	
	
	@RequestMapping(path = "/createHello", method = RequestMethod.POST)
	public String createOrUpdateHello(Hello hello) 
	{
		
		helloService.createOrUpdateHello(hello);
		
		return "redirect:/";
	}

	@RequestMapping(path = {"/view", "/view/{id}"})
	public String viewHelloById(Model model, @PathVariable("id") Optional<Long> id) 
							
	{
		
		if (id.isPresent()) {
			Hello hello = helloService.getHelloById(id.get());
			model.addAttribute("hello", hello);
		} else {
			model.addAttribute("hello", new Hello());
		}
		
		
		return "hello-view";
	}
	
}
