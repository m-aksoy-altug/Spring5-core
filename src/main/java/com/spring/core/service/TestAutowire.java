package com.spring.core.service;

public class TestAutowire {
	private String message;

	public TestAutowire() {}
	
	public TestAutowire(String message) {
		//System.out.println("TestAutowire Parameterized Constructor");
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String consumerMessage) {
		//System.out.println("TestAutowire Setter");
		this.message = consumerMessage;
	}

	public void test() {
		System.out.println("TestAutowire test: " + message);
	}
}
