package com.axioms.www.daleel.main;

import com.axioms.www.daleel.metadata.MyCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmad Ababneh on 24/02/2017.
 */

public interface MainPresenter {
    void showAllCategory();

    void navigateToCategory(MyCategory category);

    void populateList();
}
