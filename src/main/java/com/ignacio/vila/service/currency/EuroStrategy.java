package com.ignacio.vila.service.currency;

import org.springframework.stereotype.Service;

@Service
public class EuroStrategy implements CurrencyStrategy {

	@Override
	public String[] getCurrentPrice() throws CurrencyException {
		throw new CurrencyException();
	}

}
