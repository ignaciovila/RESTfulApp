package com.ignacio.vila.service.currency;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DolarStrategy implements CurrencyStrategy {

	@Override
	public String[] getCurrentPrice() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("https://www.bancoprovincia.com.ar/Principal/Dolar", String[].class);
	}
}
