package com.spring.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.service.AppConsumer;
import com.spring.core.service.AppService;
import com.spring.core.service.TestAutowire;
import com.spring.core.service.TestAutowireAnnotation;

public class SpringApp {
	
	@Autowired
    public TestAutowireAnnotation testAutowirebyUsingAutowiredAnnotation;
	
	
	public static void main(String[] args) {
				
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("applicationContext.xml");
        AppService appService = (AppService) context.getBean("appService");
        appService.test();
        appService.generatorTest();
        
        AppConsumer appConsumer = (AppConsumer) context.getBean(AppConsumer.class);
        appConsumer.test();
        
        TestAutowire testAutowirebyName = (TestAutowire) context.getBean("testAutowirebyName",TestAutowire.class);
        testAutowirebyName.test();
        
        TestAutowire testAutowireByType = (TestAutowire) context.getBean("testAutowireByType",TestAutowire.class);
        testAutowireByType.test();
        
        TestAutowire testAutowireConstructor = (TestAutowire) context.getBean("testAutowireConstructor",TestAutowire.class);
        testAutowireConstructor.test();
        
        AppService appServiceNoAutowire = (AppService) context.getBean("appServiceNoAutowire");
        appServiceNoAutowire.test();
       
        TestAutowire testBeanScopeSingleton1 = (TestAutowire) context.getBean("testAutowireScopeSingleton",TestAutowire.class);
        TestAutowire testBeanScopeSingleton2 = (TestAutowire) context.getBean("testAutowireScopeSingleton",TestAutowire.class);
        System.out.println("HashCode of testBeanScopeSingleton1:"+testBeanScopeSingleton1.hashCode());
        System.out.println("HashCode of testBeanScopeSingleton2:"+testBeanScopeSingleton2.hashCode());
        
        TestAutowire testAutowireScopePrototype1 = (TestAutowire) context.getBean("testAutowireScopePrototype");
        TestAutowire testAutowireScopePrototype2 = (TestAutowire) context.getBean("testAutowireScopePrototype");
        System.out.println("HashCode of testAutowireScopePrototype1:"+testAutowireScopePrototype1.hashCode());
        System.out.println("HashCode of testAutowireScopePrototype2:"+testAutowireScopePrototype2.hashCode());
          
        TestAutowireAnnotation testAutowireAnnotation = (TestAutowireAnnotation) context.getBean(TestAutowireAnnotation.class);
        System.out.println("HashCode of testAutowireAnnotation:"+testAutowireAnnotation.hashCode());
        testAutowireAnnotation.test();
		
        ((ClassPathXmlApplicationContext) context).close();
 
       
        ApplicationContext contextD = new AnnotationConfigApplicationContext();
        String[] beanNames = contextD.getBeanDefinitionNames();
        List<String> coreBeans = Arrays.stream(beanNames).collect(Collectors.toList());
        System.out.println("\n\n\nSpring Core Beans Registered by Default:");
        coreBeans.forEach(System.out::println);
        ((AnnotationConfigApplicationContext) contextD).close();
  }
	
		
}
