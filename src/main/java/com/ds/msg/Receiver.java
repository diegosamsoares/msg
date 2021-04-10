package com.ds.msg;

import org.springframework.stereotype.Component;

@Component
public class Receiver {


	
	public void metodoRecepitor(String message) {
		System.out.println(message);
	}
	
}
