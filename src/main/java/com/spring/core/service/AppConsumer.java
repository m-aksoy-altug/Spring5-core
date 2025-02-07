package com.spring.core.service;

public class AppConsumer {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String consumerMessage) {
		this.message = consumerMessage;
	}
	
	public void test() {
		System.out.println("AppConsumer test: " + message);
	}
}
