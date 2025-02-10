package com.spring.core.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // no bean initialization in xml, component scane will pick it as Bean
public class TestAutowireAnnotation {
	
//	// bean initialization in xml, same as byType // Autowiring on property
	@Autowired
	private XGenerator xGenerator;
	
	public void test() {
		xGenerator.testGenerator("@Autowired XGenerator inside the TestAutowired...");
	}
	
//	public TestAutowireAnnotation() {}
//	// Autowiring on parameterized constructor
//	@Autowired 
//	public TestAutowireAnnotation(XGenerator xGenerator) {
//		this.xGenerator= xGenerator;
//	}
	

//	public XGenerator getxGenerator() {
//		return xGenerator;
//	}
//	
//	// Autowiring on setter
//	@Autowired 	
//	public void setxGenerator(XGenerator xGenerator) {
//		this.xGenerator = xGenerator;
//	}

	
	
}
