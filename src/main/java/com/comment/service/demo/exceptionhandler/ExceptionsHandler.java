package com.comment.service.demo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global Exception Handler.
 * 
 * @author yuvaraj
 *
 */
public class ExceptionsHandler {

	/**
	 * Common Exception for Record not found.
	 * 
	 * @param recordNotFoundException exception.
	 * @return 404 record not found.
	 */
	@ExceptionHandler(value = RecordNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public RecordNotFoundException recordNotFoundException(RecordNotFoundException recordNotFoundException) {
		return recordNotFoundException;
	}

}
