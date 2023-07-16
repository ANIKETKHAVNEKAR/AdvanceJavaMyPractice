package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class SimpleSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SimpleSpringBootApplication.class, args);
		
		Test tobj = ctx.getBean(Test.class);
		
		tobj.logic();
		
		String [] beans = ctx.getBeanDefinitionNames();
		
		for(String bean : beans)
			System.out.println(bean);
	}

}
