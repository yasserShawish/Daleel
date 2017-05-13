package com.axioms.www.daleel.metadata;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AhmadAbabneh on 12/04/2017.
 */
public class MyCategory implements Serializable{

    private String name;
    private int id;
    private List<MarketMeta> categoryMarket;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MarketMeta> getCategoryMarket() {
        return categoryMarket;
    }

    public void setCategoryMarket(List<MarketMeta> categoryMarket) {
        this.categoryMarket = categoryMarket;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
