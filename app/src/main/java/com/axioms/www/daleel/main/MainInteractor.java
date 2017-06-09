package com.axioms.www.daleel.main;

import com.axioms.www.daleel.metadata.MyCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmad ababneh on 24/02/2017.
 */

public interface MainInteractor {

    String[] getAllCategory();
    List<MyCategory> findAllCategories();
}
