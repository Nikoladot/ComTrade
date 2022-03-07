package com.example.comtrade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.comtrade.entity.Hello;
import com.example.comtrade.repository.HelloRepository;



@Service
public class HelloService {
	
	@Autowired
	HelloRepository helloRepository;
	
	
	
	public List<Hello> getAllHellos()
	{
		List<Hello> result = (List<Hello>) helloRepository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Hello>();
		}
	}

	
	
	public Hello createOrUpdateHello(Hello hello) 
	{
		// Create new entry 
		if(hello.getId() == 0) 
		{
			hello = helloRepository.save(hello);
			
			return hello;
		} 
		else 
		{
			// update existing entry 
			Optional<Hello> helloUpdate = helloRepository.findById(hello.getId());
			
			if(helloUpdate.isPresent()) 
			{
				Hello newHello = helloUpdate.get();
				newHello.setLanguage(hello.getLanguage());
				newHello.setContent(hello.getContent());

				newHello = helloRepository.save(newHello);
				
				return newHello;
			} else {
				hello = helloRepository.save(hello);
				
				return hello;
			}
		}

	}
	
	
	public Hello getHelloById(Long id)  
	{
		Optional<Hello> hello = helloRepository.findById(id);
		
		
			return hello.get();
		
	}
	
	public void deleteHelloById(Long id) 
	{
		
		Optional<Hello> hello = helloRepository.findById(id);
		
	
			helloRepository.deleteById(id);
		
	} 
	
}
