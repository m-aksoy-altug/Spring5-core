package com.spring.core.service;

public class XGenerator implements GeneratorImp{
	@Override
	public void testGenerator(String message) {
		System.out.println("test from XGenerator:"+ message);
	}
}
