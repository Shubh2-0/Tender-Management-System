package com.masai.exception;

public class AdministratorException extends Exception {
	
	public AdministratorException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}
	
	
	

}
