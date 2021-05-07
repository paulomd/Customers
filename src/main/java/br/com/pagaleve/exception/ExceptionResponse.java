package br.com.pagaleve.exception;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date timestamp;
	private Integer code;
	private String error;
	private String message;
	private String details;
	
	public ExceptionResponse(HttpStatus status,  Date timestamp, String message, String details) {
		super();
		this.code = status.value();
		this.error = status.getReasonPhrase();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public Integer getCode() {
		return code;
	}

	public String getError() {
		return error;
	}
	
}