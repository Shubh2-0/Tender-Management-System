package com.masai.exception;

public class VendorException extends Exception{

	public VendorException(String message) {
	    
		super(message);
		
	}

	@Override
	public String toString() {
		return getMessage();
	}
	
	
	
	
	
}
