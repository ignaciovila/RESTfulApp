package com.ignacio.vila.service.currency;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
public class CurrencyException extends Exception{
	private static final long serialVersionUID = 1L;
}
