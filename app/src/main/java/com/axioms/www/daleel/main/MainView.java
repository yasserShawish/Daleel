package com.axioms.www.daleel.main;

import com.axioms.www.daleel.metadata.MyCategory;

import java.util.List;

/**
 * Created by ahmad Ababneh on 24/02/2017.
 */

public interface MainView {
    void showAllCategory();
    void navigateToCategory(MyCategory category);
    void createListView(List<MyCategory> categories);
}
