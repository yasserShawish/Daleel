package com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import com.axioms.www.daleel.metadata.MarketMeta;
import com.axioms.www.daleel.metadata.Price;
import com.axioms.www.daleel.utils.ItemType;

import java.io.Serializable;

/**
 * Created by Ahmad Ababneh on 08/05/2017.
 */

public class Item implements Serializable{
    private long id;
    private String name;
    private String description;
    private Price price;
    private int image;
    ItemType itemType;
    private MarketMeta market;

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Long getmId() {
        return id;
    }

    public MarketMeta getMarket(){
        return this.market;
    }

    public void setMarket(MarketMeta market){
        this.market = market;
    }

    public void setmId(Long id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ItemType getType(){
        return itemType;
    }

    public void setType(ItemType itemType){
        this.itemType = itemType;
    }

    public String toString() {
        return getName() + " " + getPrice();
    }

}
