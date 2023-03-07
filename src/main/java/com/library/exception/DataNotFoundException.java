package com.library.exception;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataNotFoundException()
	{
		super("Data is not present..!!");
	}
	
}
