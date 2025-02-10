package com.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.spring.core.service.AppService;
import com.spring.core.service.GeneratorImp;
import com.spring.core.service.XGenerator;
import com.spring.core.service.YGenerator;
import com.spring.core.service.TestAutowire;

@Configuration  // indicates that class has bean definitions
//@ComponentScan("com.spring.core") // Creates beans instead of explicit definition
public class AppConfig {
	
	
	@Bean("modifiedBeanNameTestAutowire") // @Bean annotated method and register the object returned by this method with Spring container
	@Scope("prototype")
	public TestAutowire testAutowire(){
		System.out.println("AppConfig: Setting bean by using @Configuration and @Bean annotations...");
		return new TestAutowire();
	}
	
	
	public GeneratorImp xGenerator(){
		return new XGenerator();
	}
	
	public GeneratorImp yGenerator(){
		return new YGenerator();
	}
	
	@Bean  // bean definition with bean dependencies through constructor injection
	public AppService xAppService() {
		System.out.println("AppConfig: xAppService: Setting bean by using @Configuration and @Bean annotation with bean dependencies through constructor injection...");
		return new AppService(xGenerator(),"message with XGenerator");
	}
	
	@Bean  
	public AppService yAppService() {
		System.out.println("AppConfig: yAppService: Setting bean by using @Configuration and @Bean annotation with bean dependencies through constructor injection...");
		return new AppService(yGenerator(),"message with YGenerator");
	}
	
}
