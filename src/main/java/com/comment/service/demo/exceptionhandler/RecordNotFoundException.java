package com.comment.service.demo.exceptionhandler;

import java.lang.reflect.Constructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 404 record not found.
 * 
 * @author yuvaraj
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9217194390380130714L;

	/**
	 * Service presenter name.
	 */
	private final String resourceName;

	/**
	 * table column name.
	 */
	private final String columnName;

	/**
	 * dynamic value which is passing through param.
	 */
	private final Object passedValue;

	/**
	 * {@link Constructor}
	 * 
	 * @param resourceName Service presenter name.
	 * @param columnName   table column name.
	 * @param passedValue  dynamic value which is passing through param.
	 */
	public RecordNotFoundException(String resourceName, String columnName, Object passedValue) {
		super(String.format("'%s' is not found with in column %s in %s", passedValue, columnName, resourceName));
		this.resourceName = resourceName;
		this.columnName = columnName;
		this.passedValue = passedValue;
	}

	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @return the passedValue
	 */
	public Object getPassedValue() {
		return passedValue;
	}

}
