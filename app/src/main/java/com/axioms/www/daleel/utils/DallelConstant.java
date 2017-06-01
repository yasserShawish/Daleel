package com.axioms.www.daleel.utils;

/**
 * Created by AhmadAbabneh on 07/04/2017.
 */

public enum DallelConstant {

    CATEGORY("category"),
    MARKET("market"),
    SHARED_PREF_NAME("myPrefName"),
    USER_LOCATION("user_location");

    private final String name;

    public String getName() {
        return this.name;
    }
    DallelConstant(String name) {
        this.name = name;
    }
}
