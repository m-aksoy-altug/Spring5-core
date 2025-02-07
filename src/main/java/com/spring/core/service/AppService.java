package com.spring.core.service;

public class AppService {
	
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void test() {
		System.out.println("test: " + message);
	}

}
