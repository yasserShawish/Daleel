package com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model;

import java.util.List;

/**
 * Created by Ahmad Ababneh on 08/05/2017.
 */

public class Cart<T> {

    private List<T> items;

    public Cart() {

    }
    public Cart(List<T> items) {
        this.items = items;
    }

    public List<T> getAllItems() {
        return items;
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public int getSize() {
        return items.size();
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
