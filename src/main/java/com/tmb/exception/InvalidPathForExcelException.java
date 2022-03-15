package com.tmb.exception;

@SuppressWarnings("serial")
public class InvalidPathForExcelException extends FrameworkException {

	public InvalidPathForExcelException(String message) {
		super(message);

	}

	public InvalidPathForExcelException(String message, Throwable cause) {
		super(message, cause);

	}
}
