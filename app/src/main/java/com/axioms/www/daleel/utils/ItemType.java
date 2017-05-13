package com.axioms.www.daleel.utils;

import android.content.Context;
import android.content.res.Resources;

import com.axioms.www.daleel.R;

/**
 * Created by Ahmad Ababneh on 12/05/2017.
 */
public enum ItemType {

    PRODUCT("منتج"),
    OFFER("عرض");

    private final String type;

    public String getType() {
        return this.type;
    }

    /*private static String getString(int stringId , Context context) {
        String label = context.getString(stringId);
        return label == null || label.isEmpty()?"":label;
    }*/
    ItemType(String type) {
        this.type = type;
    }
}
