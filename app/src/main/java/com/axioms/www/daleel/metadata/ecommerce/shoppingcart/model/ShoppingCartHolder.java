package com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model;

import com.axioms.www.daleel.metadata.Price;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ahmad Ababneh on 09/05/2017.
 */

public class ShoppingCartHolder {

    private Cart<Item> cart;
    static ShoppingCartHolder instance;

    private ShoppingCartHolder(){
        cart = new Cart<>(new HashMap<Item ,Integer>());
    }

    public Cart<Item> getCart(){
        return this.cart;
    }

    public void addToCart(Item item , int quantity)
    {
        this.cart.addItem(item , quantity);
    };

    public int shoppingCartSize(){
        return this.cart.getSize();
    }

    public void removeFromCart(Item currentItem) {
        cart.removeItem(currentItem);
    }

    public boolean isEmptyCart() {
        return cart.isEmpty();
    }

    public List<Item> getCartItems(){
        return getCart().getDisplayItems();
    }

    public Price getCartPriceTotal(){
        double allPrice = 0.0;
        String curency = null;
        for (Item item:getCartItems()) {
            int quantity = getQuantity(item);
            allPrice += item.getPrice().getPrice()*quantity;
            if(curency == null){
                curency = item.getPrice().getCurrency();
            }
        }
        return new Price(allPrice ,curency);
    }

    public int getQuantity(Item item){
        return this.cart.getQuantity(item);
    }

    public static ShoppingCartHolder Instance(){
        if(instance == null){
            instance = new ShoppingCartHolder();
        }
        return instance;
    }
}
