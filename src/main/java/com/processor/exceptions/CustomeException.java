package com.processor.exceptions;

public class CustomeException extends Exception {

	private static final long serialVersionUID = 1L;

	private String code;
	private String errDesc;

	public CustomeException(String code) {
		this.code = code;
	}

	public CustomeException(String code, String errDesc) {
		this.code = code;
		this.errDesc = errDesc;
	}

	public String handleMyException() {

		return "Exception is handled here with error code as " + code + " " + errDesc;
	}

}
