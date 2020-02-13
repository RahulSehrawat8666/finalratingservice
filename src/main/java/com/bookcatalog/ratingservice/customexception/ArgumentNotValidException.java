package com.bookcatalog.ratingservice.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArgumentNotValidException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ArgumentNotValidException(String exception)   
	{
		super(exception);
	}
}
