package com.spring.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.service.AppService;

public class SpringApp {
	
	public static void main(String[] args) {
				
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("applicationContext.xml");
        AppService appService = (AppService) context.getBean("appService");
        appService.test();
        ((ClassPathXmlApplicationContext) context).close();
        

        ApplicationContext contextD = new AnnotationConfigApplicationContext();
        String[] beanNames = contextD.getBeanDefinitionNames();
        List<String> coreBeans = Arrays.stream(beanNames).collect(Collectors.toList());
        System.out.println("Spring Core Beans Registered by Default:");
        coreBeans.forEach(System.out::println);
        ((AnnotationConfigApplicationContext) contextD).close();
  }
		
}
