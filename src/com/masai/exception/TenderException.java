package com.masai.exception;

public class TenderException extends Exception{

	public TenderException(String message) {
	
		 super(message);
		
	}

	@Override
	public String toString() {
		return getMessage();
	}
	
	
	
	
	
	
}
