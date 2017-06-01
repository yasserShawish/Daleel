package com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model;

import com.axioms.www.daleel.metadata.AbstractMeta;
import com.axioms.www.daleel.metadata.Price;
import com.axioms.www.daleel.utils.ApiUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ahmad Ababneh on 09/05/2017.
 */

public class ShoppingCartHolder {

    private Cart<Item> cart;
    static ShoppingCartHolder instance;
    static AbstractMeta curentMarket;

    private ShoppingCartHolder(){
        cart = new Cart<>(new HashMap<Item ,Integer>() , ApiUtils.getDefaultCurrency());
    }

    public Cart<Item> getCart(){
        return this.cart;
    }

    public boolean addToCart(Item item , int quantity)
    {
        if(curentMarket == null){
            curentMarket = item.getMarket();
            this.cart.addItem(item , quantity);
            return true;
        }else {
            if(curentMarket == item.getMarket()){
                this.cart.addItem(item , quantity);
                return true;
            }
            return false;
        }
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
        for (Item item:getCartItems()) {
            int quantity = getQuantity(item);
            allPrice += item.getPrice().getPrice()*quantity;
        }
        return new Price(allPrice ,cart.getCurrency());
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

    public void removeAllItems() {
        cart.removeAll();
    }
}
