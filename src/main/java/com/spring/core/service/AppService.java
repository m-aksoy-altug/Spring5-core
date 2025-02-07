package com.spring.core.service;

public class AppService {
	
	private String message;
	private GeneratorImp generatorImp;
	
	public AppService(GeneratorImp generatorInput,String message) {
		this.message=message;
		this.generatorImp= generatorInput;
	}

	public void test() {
		System.out.println("test: " + message);
	}
	
	public void generatorTest() {
		generatorImp.testGenerator(message);
	}

}
