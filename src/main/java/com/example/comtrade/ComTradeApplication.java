package com.example.comtrade;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.exemple.comtrade.aspect.LoggingAspect;



@SpringBootApplication
@EnableAspectJAutoProxy
public class ComTradeApplication {

	@Bean
	public LoggingAspect loggingAspect() {
		
		return new LoggingAspect();
	}
	
	
	public static void main(String[] args) {
			
			SpringApplication.run(ComTradeApplication.class, args);
		
		

		
		
		
	}

}
