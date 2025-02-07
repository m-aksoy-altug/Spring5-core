package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.service.AppService;

public class SpringApp {
	
	public static void main(String[] args) {
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("applicationContext.xml");
        AppService appService = (AppService) context.getBean("appService");
        appService.test();
        ((ClassPathXmlApplicationContext) context).close();	
  }
		
}
