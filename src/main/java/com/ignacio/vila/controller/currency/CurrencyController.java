package com.ignacio.vila.controller.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignacio.vila.model.currency.Currency;
import com.ignacio.vila.service.currency.CurrencyException;
import com.ignacio.vila.service.currency.CurrencyService;
import com.ignacio.vila.service.currency.DolarStrategy;
import com.ignacio.vila.service.currency.EuroStrategy;
import com.ignacio.vila.service.currency.PesosStrategy;

@RestController
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;

	@RequestMapping("/Cotizacion/Dolar")
	public Currency getDolar() throws CurrencyException {
		return currencyService.getCurrentValue(new DolarStrategy());
	}

	@RequestMapping("/Cotizacion/Euro")
	public Currency getEuro() throws CurrencyException {
		return currencyService.getCurrentValue(new EuroStrategy());
	}

	@RequestMapping("/Cotizacion/Pesos")
	public Currency getPesos() throws CurrencyException {
		return currencyService.getCurrentValue(new PesosStrategy());
	}

}