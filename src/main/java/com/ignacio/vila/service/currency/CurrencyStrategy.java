package com.ignacio.vila.service.currency;

public interface CurrencyStrategy {
	String[] getCurrentPrice() throws CurrencyException;
}
