package com.axioms.www.daleel.metadata;

import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ahmad Ababneh on 12/04/2017.
 */
public class MarketMeta extends AbstractMeta{

    private List<Item> offers;
    private MyCategory category;
    private MyAddress address;
    private List<ProductFamily> productFamily;

    public MarketMeta(){

    }

    public MarketMeta(String name , MyAddress address ){
        super(name);
        this.address = address;
    }

    public List<ProductFamily> getProductFamily() {
        return productFamily;
    }

    public void setProductFamily(List<ProductFamily> productFamily) {
        this.productFamily = productFamily;
    }

    public HashMap<ProductFamily , List<Item>> getChildProductMap(){
        HashMap<ProductFamily , List<Item>> childMap = new HashMap<>();
        for (ProductFamily item :getProductFamily()){
            childMap.put(item , item.getProducts());
        }
        return  childMap;
    }

    public List<Item> getOffers() {
        return offers;
    }

    public void setOffers(List<Item> offers) {
        this.offers = offers;
    }

    public MyCategory getCategory() {
        return category;
    }

    public void setCategory(MyCategory category) {
        this.category = category;
    }

    public MyAddress getAddress() {
        return address;
    }

    public void setAddress(MyAddress address) {
        this.address = address;
    }
}
