package com.axioms.www.daleel.metadata;

import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.Item;

import java.util.List;

/**
 * Created by Ahmad Ababneh on 12/04/2017.
 */
public class MarketMeta extends AbstractMeta{

    private List<Item> products;
    private List<Item> offers;
    private MyCategory category;
    private MyAddress address;

    public MarketMeta(){

    }

    public MarketMeta(String name , MyAddress address ){
        super(name);
        this.address = address;
    }

    public List<Item> getProducts() {
        return products;
    }

    public void setProducts(List<Item> products) {
        this.products = products;
    }

    public List<Item> getOffers() {
        return offers;
    }

    public void setOffers(List<Item> offers) {
        this.offers = offers;
    }

    public MyCategory getCategory() {
        return category;
    }

    public void setCategory(MyCategory category) {
        this.category = category;
    }

    public MyAddress getAddress() {
        return address;
    }

    public void setAddress(MyAddress address) {
        this.address = address;
    }
}
