package com.spring.core.service;

public class AppService {
	
	private String message;
	private Generator generator;
	
	public AppService(Generator generatorInput,String message) {
		this.message=message;
		this.generator= generatorInput;
	}

	public void test() {
		System.out.println("test: " + message);
	}
	
	public void generatorTest() {
		generator.testGenerator(message);
	}

}
