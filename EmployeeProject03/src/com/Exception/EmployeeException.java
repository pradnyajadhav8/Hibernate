package com.Exception;

public class EmployeeException extends RuntimeException{

	public EmployeeException() {
		
	}
	
	public EmployeeException(String msg) {
		super(msg);
	}
	
	public EmployeeException(String msg, Throwable cause) {
		super(msg);
	}
	
}
