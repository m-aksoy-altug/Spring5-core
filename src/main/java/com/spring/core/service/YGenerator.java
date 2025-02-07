package com.spring.core.service;

public class YGenerator implements GeneratorImp{
	@Override
	public void testGenerator(String message) {
		System.out.println("Test from YGenerator:"+ message);
	}
}
