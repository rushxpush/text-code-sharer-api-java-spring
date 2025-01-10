package com.textcodesharer.text_code_sharer.document;

public class ParameterNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ParameterNotFoundException(String param) {
		super(param + " cannot be null.");
	}
}
