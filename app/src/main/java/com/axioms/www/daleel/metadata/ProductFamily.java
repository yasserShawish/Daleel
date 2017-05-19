package com.axioms.www.daleel.metadata;

import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.Item;

import java.util.List;

/**
 * Created by Ahmad Ababneh on 5/17/2017.
 */

public class ProductFamily extends AbstractMeta {

    private List<Item> products;

    public ProductFamily(){

    }

    public ProductFamily(String name){
        super(name);
    }

    public List<Item> getProducts() {
        return products;
    }

    public void setProducts(List<Item> products) {
        this.products = products;
    }
}
