package com.example.comtrade;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.comtrade.aspect.LoggingAspect;



@SpringBootApplication
@EnableAspectJAutoProxy
public class ComTradeApplication {


	
	public static void main(String[] args) {
			
			SpringApplication.run(ComTradeApplication.class, args);
		
		

		
		
		
	}

}
