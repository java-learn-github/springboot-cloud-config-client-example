package com.processor.exceptions;

public class FileNotWriteException extends CustomeException {

	private static final long serialVersionUID = 1L;

	private static String errorCode = "ERR_FILE_NOT_FOUND";

	private static String errDesc = "File Not Found Idiot!";

	public FileNotWriteException() {
		super(errorCode, errDesc);

	}

}
