package com.axioms.www.daleel.metadata;

import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.Item;
import com.axioms.www.daleel.utils.ItemType;

/**
 * Created by Ahmad Ababneh on 12/04/2017.
 */
public class Product extends Item{

    public Product(){

    }

    public Product(String name){
        super(name);
    }

    public ItemType getType(){
        return ItemType.PRODUCT;
    }

}
