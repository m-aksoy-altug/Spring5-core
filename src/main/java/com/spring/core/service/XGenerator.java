package com.spring.core.service;

public class XGenerator implements GeneratorImp{
	@Override
	public void testGenerator(String message) {
		System.out.println("Test from XGenerator:"+ message);
	}
}
