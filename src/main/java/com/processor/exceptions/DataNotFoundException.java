package com.processor.exceptions;

public class DataNotFoundException extends CustomeException {

	private static final long serialVersionUID = 1L;

	private static String errorCode = "ERR_DATA_NOT_FOUND";

	public DataNotFoundException() {
		super(errorCode);
	}

}
