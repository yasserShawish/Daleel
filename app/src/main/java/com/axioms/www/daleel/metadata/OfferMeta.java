package com.axioms.www.daleel.metadata;

import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.Item;
import com.axioms.www.daleel.utils.ItemType;

/**
 * Created by Ahmad Ababneh on 12/04/2017.
 */
public class OfferMeta extends Item{

    public OfferMeta(){

    }

    public ItemType getType(){
        return ItemType.OFFER;
    }
}
