package com.axioms.www.daleel.metadata;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AhmadAbabneh on 12/04/2017.
 */
public class MyCategory implements Serializable{

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String image;
    private List<MarketMeta> categoryMarket;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
