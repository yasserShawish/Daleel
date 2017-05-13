package com.axioms.www.daleel.metadata;

import java.io.Serializable;

/**
 * Created by Ahmad Ababneh on 02/05/2017.
 */

public class Price implements Serializable{

    String currency;
    double price;

    public Price(){

    }
    public Price(double price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
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
        return price+""+currency;
    }
}
