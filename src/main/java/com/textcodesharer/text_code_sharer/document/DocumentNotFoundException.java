package com.textcodesharer.text_code_sharer.document;

public class DocumentNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DocumentNotFoundException(Long id) {
		super("Could not find employee with id: " + id);
	}

}
