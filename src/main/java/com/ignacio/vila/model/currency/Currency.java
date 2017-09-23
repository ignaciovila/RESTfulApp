package com.ignacio.vila.model.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ignacio.vila.service.currency.CurrencyException;
import com.ignacio.vila.service.currency.CurrencyStrategy;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    private String buyPrice;
    private String sellPrice;
    private String updated;

    private CurrencyStrategy currencyStrategy;

    public Currency(CurrencyStrategy currencyStrategy) {
        this.currencyStrategy = currencyStrategy;
    }

    public void getCurrentPrice() throws CurrencyException {
        String[] response = currencyStrategy.getCurrentPrice();
        setBuyPrice(response[0]);
        setSellPrice(response[1]);
        setUpdated(response[2]);
    }

    private void setBuyPrice(final String buyPrice) {
        this.buyPrice = buyPrice;
    }

    private void setSellPrice(final String sellPrice) {
        this.sellPrice = sellPrice;
    }

    private void setUpdated(final String updated) {
        this.updated = updated;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public String getUpdated() {
        return updated;
    }

}