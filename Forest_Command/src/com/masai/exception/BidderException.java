package com.masai.exception;

public class BidderException extends Exception{

	public BidderException(String message) {
	    
		super(message);
		
	}

	@Override
	public String toString() {
		return getMessage();
	}
	
	
	
	
}
