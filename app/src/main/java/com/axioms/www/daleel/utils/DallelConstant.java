package com.axioms.www.daleel.utils;

/**
 * Created by AhmadAbabneh on 07/04/2017.
 */

public enum DallelConstant {

    CATEGORY("category"),
    MARKET("market");

    private final String name;

    public String getName() {
        return this.name;
    }
    DallelConstant(String name) {
        this.name = name;
    }
}
