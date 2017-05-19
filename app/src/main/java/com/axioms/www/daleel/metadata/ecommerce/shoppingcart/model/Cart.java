package com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ahmad Ababneh on 08/05/2017.
 */

public class Cart<T> {

    private HashMap<T , Integer> items;
    private List<T> displayItems;

    public Cart() {

    }

    public Cart(HashMap<T , Integer> items) {
        this.items = items;
        this.displayItems = new ArrayList<>();
    }

    public HashMap<T , Integer> getAllItems() {
        return items;
    }

    public void addItem(T item , int quantity) {
        if(items.get(item) == null){
            items.put(item , quantity);
            displayItems.add(item);
        }else{
            int  val = items.get(item);
            val+=quantity;
            items.put(item , val);
        }
    }

    public void removeItem(T item) {
        int oldVal = items.get(item);
        if(oldVal == 1){
            items.remove(item);
            displayItems.remove(item);
        }else{
            items.put(item , --oldVal);
        }
    }

    public int getSize() {
        int sum = 0;
        for (Integer value : items.values()){
            sum+=value;
        }
        return sum;
    }

    public List<T> getDisplayItems() {
        return displayItems;
    }

    public void setDisplayItems(List<T> displayItems) {
        this.displayItems = displayItems;
    }

    public int getQuantity(T item){
        return this.items.get(item);
    }

    public void setItems(HashMap<T , Integer> items) {
        this.items = items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
