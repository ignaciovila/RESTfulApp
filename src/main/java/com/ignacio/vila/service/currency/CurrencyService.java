package com.ignacio.vila.service.currency;

import com.ignacio.vila.model.currency.Currency;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
	public Currency getCurrentValue(CurrencyStrategy strategy) throws CurrencyException {
		Currency currency = new Currency(strategy);
		currency.getCurrentPrice();
		return currency;
	}
}
