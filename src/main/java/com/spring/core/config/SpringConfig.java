package com.spring.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@EnableAspectJAutoProxy 
@ComponentScan(basePackages= {"com.spring.core.servicejava","com.spring.core.aop","com.spring.core.repo"})
// Skipping some of the bean initialization because of XML bean implementation
@PropertySource("classpath:application.properties")
public class SpringConfig {
	@Autowired
	Environment env;	
	
    public String getAppName() {
        return env.getProperty("app.name"); 
    }
}
