package com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model;

import com.axioms.www.daleel.metadata.Price;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmad Ababneh on 09/05/2017.
 */

public class ShoppingCartHolder {

    private Cart<Item> cart;
    static ShoppingCartHolder instance;

    private ShoppingCartHolder(){
        cart = new Cart<>(new ArrayList<Item>());
    }

    public Cart<Item> getCart(){
        return this.cart;
    }

    public void addToCart(Item item)
    {
        this.cart.addItem(item);
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
        return this.cart.getAllItems();
    }

    public Price getCartPriceTotal(){
        double allPrice = 0.0;
        String curency = null;
        for (Item item:getCartItems()) {
            allPrice += item.getPrice().getPrice();
            if(curency == null){
                curency = item.getPrice().getCurrency();
            }
        }
        return new Price(allPrice ,curency );
    }

    public static ShoppingCartHolder Instance(){
        if(instance == null){
            instance = new ShoppingCartHolder();
        }
        return instance;
    }
}
