package com.axioms.www.daleel.metadata;

import java.io.Serializable;
import java.util.Currency;

/**
 * Created by Ahmad Ababneh on 02/05/2017.
 */

public class Price implements Serializable{

    Currency currency;
    double price;

    public Price(){

    }
    public Price(double price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return price+""+currency.getCurrencyCode();
    }
}
