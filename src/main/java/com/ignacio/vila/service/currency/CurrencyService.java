package com.ignacio.vila.service.currency;

import org.springframework.stereotype.Service;

import com.ignacio.vila.model.currency.Currency;

@Service
public class CurrencyService {
	public Currency getCurrentValue(CurrencyStrategy strategy) throws CurrencyException {
		Currency currency = new Currency(strategy);
		currency.getCurrentPrice();
		return currency;
	}
}
